package por;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj {
	static int[] x_loc= {1,-1,0,0};
	static int[] y_loc= {0,0,1,-1};
	static int N;
	static int M;
	static int size=1;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    N=Integer.parseInt(str[0]);M=Integer.parseInt(str[1]);
	    int[][]map=new int[N][M];
	    boolean[][]visited=new boolean[N][M];
	    
	    for(int i=0;i<N;i++) {
	    	for(int j=0;j<M;j++) {
	    		if(check_outside(i, j, map)) {
	    			dfs(i,j,map);
	    		}
	    	}
	    }
	}
	static public void dfs(int n,int m,int[][]map,boolean[][]visited) {
		visited[n][m]=true;
		while(true) {
			
		}
	}
	static public boolean check_outside(int n,int m,int [][]map) {
		if( n==0 || m==0 || n==N-1 || m==M-1) {
			return true;
		}
		else {
			if(map[n-1][m]==0 || map[n][m-1]==0 || map[n][m+1]==0 || map[n-1][m]==0) {
				return true;
			}
		}
		return false;
	}
}
class Location{
	int x;
	int y;
	int count;
	Location(int x,int y,int count){
		this.x=x;
		this.y=y;
		this.count=count;
	}
}
