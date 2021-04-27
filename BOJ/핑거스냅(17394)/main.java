package por;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class bj {
	static int ex;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb=new StringBuilder();
	    int T=Integer.parseInt(br.readLine());
	    
	    for(int i=0;i<T;i++) {
		    String[]str=br.readLine().split(" ");
		    sb.append(bfs(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));
		    sb.append("\n");
	    }
	    sb.delete(sb.length()-1, sb.length());
	    System.out.println(sb);

	}
	static public int bfs(int N,int A, int B) {
		Queue<Finger>queue=new LinkedList<>();
		boolean[] visited=new boolean[1000001];
		visited[N]=true;
		queue.add(new Finger(N,0));
		while(queue.size()!=0) {
			Finger f=queue.poll();
			if(f.number>=A && f.number<=B && isPrime(f.number)) {
				return f.count;
			}
			for(int i=0;i<4;i++) {
				cases(f.number,i,queue,f.count,visited);
			}
		}
		return -1;
	}
	static public void cases(int number,int option,Queue<Finger>queue,int count,boolean[]visited) {
		if(number>0) {
			switch(option) {
			case 0:
				if(number/2>0 && !visited[number/2]) {
					queue.add(new Finger(number/2,count+1));
					visited[number/2]=true;
				}
				break;
			case 1:
				if(number/3>0 && !visited[number/3]) {
					queue.add(new Finger(number/3,count+1));
					visited[number/3]=true;
				}
				break;
			case 2:
				if(number+1<100001 && !visited[number+1]) {
					queue.add(new Finger(number+1,count+1));
					visited[number+1]=true;
				}
				break;
			case 3:
				if(number-1>0 && !visited[number-1]) {
					queue.add(new Finger(number-1,count+1));
					visited[number-1]=true;
				}
				break;
			}
		}
	}
	static public boolean isPrime(int number) {
		if(number==1 || number==0) {return false;}
		for(int i=2;i<number;i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
}
class Finger{
	int number;
	int count;
	Finger(int number,int count){
		this.count=count;
		this.number=number;
	}
}
