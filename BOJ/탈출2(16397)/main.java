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
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split("");
	    
	    int N=Integer.parseInt(str[0]);//N:기본값
	    int T=Integer.parseInt(str[1]);//T총횟수
	    int G=Integer.parseInt(str[2]);//G:결과값
	    
	    boolean[]visited=new boolean[2];
	    
	    message=bfs(0,visited,N,T,G);
	    System.out.println(message);
	    
	}
	
	static public String bfs(int v, boolean[]visited,int N,int T,int G) {
		visited[v]=true;//visited[0]=>A,visited[1]=>B
		Queue<Func>queue=new LinkedList<>();
		queue.add(new Func(visited[v],N,0));
		Func f=null;
		while(f.getCount()<T) {
			f=queue.poll();
			if(N==G) {
				break;
			}
			else if(f.boom==false) {
				return "ANG";
			}
			queue.add(new Func(true,N,f.count+1));
			queue.add(new Func(false,N,f.count+1));
		}
		return Integer.toString(f.count);
	}
}

class Func{
	int count=1;
	int num;
	boolean boom;
	Func(boolean where,int num,int count){
		this.count=count;
		if(where) {
			this.num+=1;
			return;
		}
		if(num*2>99999) {
			this.boom=false;
			return;
		}
		StringBuilder sb=new StringBuilder();
		String []b=Integer.toString(num*2).split("");
		int c=Integer.parseInt(b[0])-1;
		if(c<=0) {
			for(int i=1;i<b.length;i++) {
				sb.append(b[i]);
			}
			this.num=Integer.parseInt(sb.toString());
		}
		else {
			sb.append(Integer.toString(c));
			for(int i=1;i<b.length;i++) {
				sb.append(b[i]);
			}
			this.num=Integer.parseInt(sb.toString());
		}
		
	}
	
	public int getCount() {
		return count;
	}
	
	public void setBoom() {
		this.boom=true;
	}
}
