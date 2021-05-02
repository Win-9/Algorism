import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	static int[] x_loc= {1,-1,0,0};
	static int[] y_loc= {0,0,1,-1};
	static int N;
	static int M;
	static int size=1;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    ArrayList<Integer>list=new ArrayList<Integer>();
	    M=Integer.parseInt(str[0]);
	    N=Integer.parseInt(str[1]);
	    int K=Integer.parseInt(str[2]);
	    int[][]map=new int[N][M];
	    boolean[][]visited=new boolean[N+1][M+1];
	    for(int i=0;i<K;i++) {
	    	str=br.readLine().split(" ");
	    	int x1=Integer.parseInt(str[0]);int y1=Integer.parseInt(str[1]);
	    	int x2=Integer.parseInt(str[2]);int y2=Integer.parseInt(str[3]);
	    	area(map,x1,y1,x2,y2);
	    }
	    int count=0;
	    for(int i=0;i<N;i++) {
	    	for(int j=0;j<M;j++) {
	    		if(map[i][j]!=1 && !visited[i][j]) {
	    			list.add(dfs(i,j,map,visited));
	    			++count;
	    			size=1;
	    		}
	    	}
	    }
	    
	    System.out.println(count);
	    Collections.sort(list);
	    for(int i=0;i<list.size();i++) {
	    	System.out.print(list.get(i)+" ");
	    }
	   
	}
	static int dfs(int x,int y,int[][] map,boolean[][]visited) {
		visited[x][y]=true;
		for(int i=0;i<4;i++) {
			int ex1=x+x_loc[i];
			int ex2=y+y_loc[i];
			
			if((ex1<N && ex1>=0) && (ex2<M && ex2>=0) && map[ex1][ex2]!=1 && !visited[ex1][ex2]) {
				visited[ex1][ex2]=true;
				dfs(ex1,ex2,map,visited);
				++size;
			}
		}
		return size;
		
	}
	static void area(int[][]map,int x1,int y1,int x2,int y2) {
		for(;x1<x2;x1++) {
			
			for(int j=y1;j<y2;j++) {
				map[x1][j]=1;
			}
		}
	}
}
