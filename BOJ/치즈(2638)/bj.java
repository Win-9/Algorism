package por;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj {
	static int[] x_loc= {1,-1,0,0};
	static int[] y_loc= {0,0,1,-1};
	static int N;
	static int M;
	static int count=1;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    N=Integer.parseInt(str[0]);M=Integer.parseInt(str[1]);
	    File file=new File("C:\\Users\\LG\\ss.txt");
	    int[][]map=new int[N][M];
	    boolean[][]visited=new boolean[N][M];
    	FileReader fr=new FileReader(file);
    	br = new BufferedReader(fr);
    	String cur="";int q=0;
    	while((cur=br.readLine())!=null) {
    		str=cur.split(" ");
    		for(int j=0;j<M;j++) {
	    		map[q][j]=Integer.parseInt(str[j]);
	    	}
    		q++;
    	}
	    
	    /*for(int i=0;i<N;i++) {
	    	str=br.readLine().split(" ");
	    	for(int j=0;j<M;j++) {
	    		map[i][j]=Integer.parseInt(str[j]);
	    	}
	    }*/
	    while(true) {
	    	boolean is_in=false;
	    	for(int i=0;i<N;i++) {
	    		for(int j=0;j<M;j++) {
	    			System.out.print(map[i][j]+" ");
	    		}
	    		System.out.println();
	    	}
	    	System.out.println("===========================");
	    	for(int i=0;i<N;i++) {
		    	for(int j=0;j<M;j++) {
		    		if(check_outside(i, j, map)) {
		    			System.out.println("dfs x:"+i+" y:"+j);
		    			dfs(i,j,map,visited);
		    			is_in=true;
		    		}
		    	}
		    }
	    	if(is_in==false)
	    		break;
	    	++count;
	    	Change(map, visited);
	    }
	    System.out.println("count:"+count);
	}
	
	static public void dfs(int n,int m,int[][]map,boolean[][]visited) {
		visited[n][m]=true;
		System.out.println("x:"+n+" y:"+m);
		for(int i=0;i<4;i++) {
			int ex1=n+x_loc[i];
			int ex2=m+y_loc[i];
			if (check(ex1,ex2,map,visited)){//
				visited[ex1][ex2]=true;
				dfs(ex1,ex2,map,visited);
			}
		}
	}
	static public void Change(int[][]map,boolean[][]visited) {
		for(int i=0;i<N;i++) {
	    	for(int j=0;j<M;j++) {
	    		if(visited[i][j] && map[i][j]==1) {
	    			map[i][j]=0;
	    		}
	    	}
	    }
	}
	static public boolean check(int ex1,int ex2, int [][]map,boolean[][]visited) {
		if((ex1>=0 && ex1<N) && (ex2>=0 && ex2<M) && check_outside(ex1, ex2, map) && !visited[ex1][ex2]) {
			return true;
		}
		return false;
	}
	static public boolean check_outside(int n,int m,int [][]map) {
		if(map[n][m]==1) {
			if( n==0 || m==0 || n==N-1 || m==M-1) {//양끝좌표가 1이면 무조건 녹음
				return true;
			}
			else if(map[n-1][m]==0 || map[n][m-1]==0 || map[n][m+1]==0 || map[n-1][m]==0) {//1인것에서 십자좌표탐색
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
