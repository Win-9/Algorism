버튼 A를 누르면 N이 1 증가한다.
버튼 B를 누르면 N에 2가 곱해진 뒤, 0이 아닌 가장 높은 자릿수의 숫자가 1 줄어든다. 예를 들어 123→146으로, 5→0으로, 3→5로 변한다. 단, N이 0이면 버튼 B를 눌러도 수가 변하지 않는다.
LED가 다섯 자리까지밖에 없기 때문에 N이 99,999를 넘어가는 순간 탈출에 실패하게 된다.
버튼 B를 눌러 N에 2를 곱한 순간 수가 99,999를 넘어간다면, 높은 자릿수의 수를 1 낮췄을때 99,999를 넘지 않는다고 해도 탈출에 실패하게 된다.
또한 홍익이는 최대 T회 버튼을 누를 수 있고, 그 횟수 안에 LED로 표현된 N을 G와 같게 만들어야 탈출할 수 있다는 사실을 알아냈다.

똑똑한 홍익이는 이와중에 자존심이 발동해 버튼 누르는 횟수를 최소로 하여 방을 탈출하기로 했다.

홍익이의 방 탈출을 기원하며, 탈출에 필요한 최소의 버튼 횟수를 구하자.




package por;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class bj {
	static String message;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    
	    int N=Integer.parseInt(str[0]);//N:기본값
	    int T=Integer.parseInt(str[1]);//T총횟수
	    int G=Integer.parseInt(str[2]);//G:결과값
	    	    
	    message=bfs(N,T,G);
	    System.out.println(message);
	    
	}
	
	static public String bfs(int N,int T,int G) {
		Queue<Func>queue=new LinkedList<>();
		boolean[]visited=new boolean[100000];
		visited[N]=true;
		queue.add(new Func(N,0));
		Func f=null;
		do {
			f=queue.poll();
			if(!f.ButtonA(f.getNum(), visited)) {
				if(f.ex1==G) {
					return Integer.toString(f.count+1);
				}
				else if(f.boom==false) {
					return "ANG";
				}
				queue.add(new Func(true,f.ex1,f.getCount()+1,visited));
			}
			if(!f.ButtonB(f.getNum(), visited)) {
				if(f.ex2==G) {
					return Integer.toString(f.count+1);
				}
				else if(f.boom==false) {
					return "ANG";
				}
				queue.add(new Func(false,f.ex2,f.getCount()+1,visited));
			}
		}while(f.getCount()<=T);
		
		return "ANG";
	}
}

class Func{
	int ex1;
	int ex2;
	int count;
	int num;
	boolean boom=true;
	Func(int num,int count){
		this.num=num;
		this.count=count;
	}
	Func(boolean where,int num,int count,boolean[]visited){
		this.count=count;
		if(num*2>99999) {
			this.boom=false;
			visited[num]=true;
			return;
		}
		if(where) {//A button
			this.num=num;
			visited[ex1]=true;
		}
		else {
			this.num=num;
			visited[this.num]=true;
		}
	}
	
	public boolean ButtonA(int num,boolean[] visited) {
		ex1=(num+1);
		return visited[ex1];
	}
	
	public boolean ButtonB(int num,boolean[] visited) {
		StringBuilder sb=new StringBuilder();
		String []b=Integer.toString(num*2).split("");
		int c=Integer.parseInt(b[0])-1;
		if(c<0) {
			ex2=0;
			this.num=ex2;
			return visited[0];
		}
		sb.append(Integer.toString(c));
		for(int i=1;i<b.length;i++) {
			sb.append(b[i]);
		}
		ex2=Integer.parseInt(sb.toString());
		return visited[ex2];
	}
	
	public int getCount() {
		return count;
	}
	
	public int getNum() {
		return num;
	}
}
