package por;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Main {
	  public static void main(String[] args) throws IOException {
		  Solution s=new Solution();
		  s.solution();
	  }
	}
class Solution{
	  static int[]x_loc={1,-1,0,0};
	  static int[]y_loc={0,0,1,-1};
	  static int number;
	  static Queue<Location>queue=new LinkedList<>();
	  public void solution() throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<Integer>list=new ArrayList<>();
	    number=Integer.parseInt(br.readLine());
	    int [][]map=new int[number+1][number+1];
	    boolean[][]visited=new boolean[number+1][number+1];
	    int last_x;int last_y;int second;
	    for(int i=1;i<=number+1;i++){
	      String[]str=br.readLine().split("");
	      for(int j=1;j<number+1;j++){
	    	  if(i==number+1) {
	    		  second=Integer.parseInt(str[0]);
	    		  last_x=Integer.parseInt(str[1]);
	    		  last_y=Integer.parseInt(str[2]);
	    	  }
	    	  map[i][j]=Integer.parseInt(str[j]);
	      }
	    }
	    for(int i=1;i<number+1;i++){
	      for(int j=1;j<number+1;j++){
	        if(!visited[i][j] && map[i][j]!=0){
	          queue.add(new Location(i,j));
	        }
	      }
	    }
	    bfs(visited,map,0,0);
	  }
	  public void bfs(boolean[][]visited,int[][]map,int i,int j){
		  Queue<Location>queue=new LinkedList<>();
		  queue.add(new Location(i,j));
		  visited[i][j]=true;
		  while(queue.size()!=0) {
			  Location loc=queue.poll();
			  for(int k=0;k<4;k++) {
				  int ex1=loc.x+x_loc[k];
				  int ex2=loc.y+y_loc[k];
				  if(check(visited,ex1,ex2,map)) {
					  queue.add(new Location(ex1, ex2));
				  }
			  }
		  }
	  }
	  public boolean check(boolean[][]visited,int ex1,int ex2,int[][]map){
	    if((ex1>=0 && ex1<number)&&(ex2>=0 && ex2<number)&&!visited[ex1][ex2]&& map[ex1][ex2]==1){
	      visited[ex1][ex2]=true;
	      return true;
	    }
	    return false;
	  }
}
class Location{
	  int x;
	  int y;
	  Location(int x,int y){
	    this.x=x;
	    this.y=y;
	  }
}