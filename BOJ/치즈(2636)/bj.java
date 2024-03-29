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
	static int count=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[]str=br.readLine().split(" ");
	    N=Integer.parseInt(str[0]);M=Integer.parseInt(str[1]);
	    File file=new File("C:\\Users\\LG\\ss.txt");
	    int[][]map=new int[N][M];
	    boolean[][]hole_check=new boolean[N][M];//구멍이명 false
	    boolean[][]visited=new boolean[N][M];
    	FileReader fr=new FileReader(file);
    	br = new BufferedReader(fr);
    	String cur="";int q=0;
    	while((cur=br.readLine())!=null) {//맵만들기
    		str=cur.split(" ");
    		for(int j=0;j<M;j++) {
	    		map[q][j]=Integer.parseInt(str[j]);
	    	}
    		q++;
    	}
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			if((i==0||j==0||i==N-1||j==M-1) && !visited[i][j] && map[i][j]==0) {
    				dfs_for_hole(i, j, map, visited,hole_check);
    			}
    			System.out.print(hole_check[i][j]+"\t");
    		}
    		System.out.println();
    	}
    	visited=new boolean[N][M];
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
	    	System.out.println("==============count: "+count+"=============");
	    	for(int i=0;i<N;i++) {
		    	for(int j=0;j<M;j++) {
		    		if(check_outside(i, j, map,hole_check) && !visited[i][j]) {
		    			dfs(i,j,map,visited,hole_check);
		    			is_in=true;
		    		}
		    	}
		    }
	    	if(is_in==false)
	    		break;
	    	++count;
	    	Change(map, visited);
			Contect_air(hole_check,visited,map);
	    }
	    System.out.println("count:"+count);
	}
	static public void dfs_for_hole(int n,int m,int[][]map,boolean[][]visited,boolean[][]hole_check) {
		visited[n][m]=true;
		hole_check[n][m]=true;
		for(int i=0;i<4;i++) {
			int ex1=n+x_loc[i];
			int ex2=m+y_loc[i];
			if (check_another(ex1,ex2,map,visited)){
				visited[ex1][ex2]=true;
				hole_check[ex1][ex2]=true;
				dfs_for_hole(ex1,ex2,map,visited,hole_check);
			}
		}
	}
	static public void Contect_air(boolean[][]hole_check,boolean[][]visited,int[][]map) {
		for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			if(visited[i][j]==false && check_Change(i, j, map)) {
    				dfs_Change(i,j,hole_check);
    			}
    		}
    	}
	}
	static public boolean check_Change(int n,int m,int [][]map) {
		if(n==0 || m==0 || n==N-1 || m==M-1||
				(map[n-1][m]==0) ||(map[n][m-1]==0)|| (map[n][m+1]==0)|| (map[n+1][m]==0)) {
			return true;
		}
		return false;
	}
	static public void dfs_Change(int n,int m,boolean[][]hole_check) {
		hole_check[n][m]=true;
		for(int i=0;i<4;i++) {
			int ex1=n+x_loc[i];
			int ex2=m+y_loc[i];
			if ((ex1>=0 && ex1<N) && (ex2>=0 && ex2<M) && hole_check[ex1][ex2]==false){
				hole_check[ex1][ex2]=false;
				dfs_Change(ex1,ex2,hole_check);
			}
		}
	}
	static public void dfs(int n,int m,int[][]map,boolean[][]visited,boolean[][]hole_check) {
		visited[n][m]=true;
		for(int i=0;i<4;i++) {
			int ex1=n+x_loc[i];
			int ex2=m+y_loc[i];
			if (check(ex1,ex2,map,visited,hole_check)){
				visited[ex1][ex2]=true;
				dfs(ex1,ex2,map,visited,hole_check);
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

	static public boolean check(int ex1,int ex2, int [][]map,boolean[][]visited,boolean[][]hole_check) {
		if((ex1>=0 && ex1<N) && (ex2>=0 && ex2<M) && check_outside(ex1, ex2, map,hole_check) && !visited[ex1][ex2]) {
			return true;
		}
		return false;
	}
	static public boolean check_another(int ex1,int ex2, int [][]map,boolean[][]visited) {
		if((ex1>=0 && ex1<N) && (ex2>=0 && ex2<M) && !visited[ex1][ex2] && map[ex1][ex2]==0) {
			return true;
		}
		return false;
	}
	static public boolean check_outside(int n,int m,int [][]map, boolean[][]hole_check) {
		if(map[n][m]==1) {
			if( n==0 || m==0 || n==N-1 || m==M-1) {//가쪽이 1이면 무조건 녹음
				return true;
			}
			else if((map[n-1][m]==0 && hole_check[n-1][m]==true) || 
					(map[n][m-1]==0 && hole_check[n][m-1]==true)|| 
					(map[n][m+1]==0 && hole_check[n][m+1]==true)|| 
					(map[n+1][m]==0 && hole_check[n+1][m]==true)) {//1인것에서 십자좌표탐색
				return true;
			}
		}
		return false;
	}
	
}
