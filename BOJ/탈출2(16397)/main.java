package por;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class bj {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split("");
	    
	    int N=Integer.parseInt(str[0]);//N:기본값
	    int T=Integer.parseInt(str[1]);//T총횟수
	    int G=Integer.parseInt(str[2]);//G:결과값
	    
	    boolean[]visited=new boolean[2];
	    ArrayList[] list=new ArrayList[2];
	    for(int i=0;i<2;i++) {
	    	list[i]=new ArrayList<Func>();
	    }
	    
	    list[0].add(true);
	    list[1].add(false);
	    
	    bfs(list,0,visited,N,T);
	    
	}
	
	static public void bfs(ArrayList[]list,int v, boolean[]visited,int N,int T) {
		visited[v]=true;//visited[0]=>A,visited[1]=>B
		Queue<Func>queue=new LinkedList<>();
		queue.add(new Func(visited[v],N,0));
		Func f=queue.poll();
		while(f.getCount()>T) {
			queue.add(new Func(true,N,f.count+1));
			queue.add(new Func(false,N,f.count+1));
			f=queue.poll();
		}
		
	}
}

class Func{
	int count;
	int num;
	
	Func(boolean where,int num,int count){
		this.count=count;
		if(where) {
			this.num+=1;
			return;
		}
		StringBuilder sb=new StringBuilder();
		String []b=Integer.toString(num*2).split("");
		int c=Integer.parseInt(b[0])-1;
		if(c<0) {
			for(int i=1;i<b.length;i++) {
				sb.append(b[i]);
			}
		}
		else {
			sb.append(Integer.toString(c));
			for(int i=1;i<b.length;i++) {
				sb.append(b[i]);
			}
		}
		this.num=Integer.parseInt(sb.toString());
	}
	
	public int getCount() {
		return count;
	}
}
