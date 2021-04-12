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
	    	list[i]=new ArrayList<Boolean>();
	    }
	    
	    list[0].add(true);
	    list[1].add(false);
	    
	    bfs(list,0,visited,N,T);
	    
	}
	
	static public void bfs(ArrayList[]list,int v, boolean[]visited,int N,int T) {
		visited[v]=true;//visited[0]=>A,visited[1]=>B
		Queue<Integer>queue=new LinkedList<>();
		queue.add(Func(visited[v],N));
		for(int i=1;i<T;i++) {
			int w=queue.poll();
			Iterator iter=list[v].iterator();
			while(iter.hasNext()) {
				Object nex=iter.next();
				queue.add(Func((boolean)nex, w));
			}
		}
		
		
	}
	
	static public int Func(boolean where,int a) {
		if(where) {
			a+=1;
			return a;
		}
		StringBuilder sb=new StringBuilder();
		String []b=Integer.toString(a*2).split("");
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
		
		return Integer.parseInt(sb.toString());
	}
}
