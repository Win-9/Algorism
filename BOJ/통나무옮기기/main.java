package por;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Main{
	  static int[]x_loc={1,-1,0,0};
	  static int[]y_loc={0,0,1,-1};
	  static int number;
	  static int second=0;
	  static Queue<Location>queue=new LinkedList<>();
	  public static void main(String[]args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<Location>add_list=new ArrayList<Location>();
	    String[] str=br.readLine().split(" ");
	    number=Integer.parseInt(str[0]);
	    String [][]map=new String[number][number];
	    boolean[][]visited=new boolean[number][number];
	    int last_x=0;int last_y=0;
	    for(int i=0;i<=number+1;i++){
	      str=br.readLine().split(" ");
	      for(int j=0;j<number;j++){
	    	  map[i][j]=str[j];
	      }
	    }
	    
	  }
	  static public void bfs(boolean[][]visited,int[][]map,int i,int j){
		  visited[i][j]=true;
		  while(queue.size()!=0) {
			  Location loc=queue.poll();
			  if(loc.count==second) {
				  break;
			  }
			  for(int k=0;k<4;k++) {
				  int ex1=loc.x+x_loc[k];
				  int ex2=loc.y+y_loc[k];
				  if(check(visited,ex1,ex2,map)) {
					  map[ex1][ex2]=loc.num;
					  queue.add(new Location(ex1, ex2,loc.num,++loc.count));  
				  }
			  }
		  }
	  }
	  static public boolean check(boolean[][]visited,int ex1,int ex2,int[][]map){
	    if((ex1>0 && ex1<=number)&&(ex2>0 && ex2<=number)&&!visited[ex1][ex2]){
	      visited[ex1][ex2]=true;
	      return true;
	    }
	    return false;
	  }
}
class Location implements Comparable<Location>{
	  int x;
	  int y;
	  int num;
	  int count;
	  Location(int x,int y,int num,int count){
	    this.x=x;
	    this.y=y;
	    this.num=num;
	    this.count=count;
	  }
	@Override
	public int compareTo(Location loc) {
		if(this.num-loc.num>0) {
			return 1;
		}
		else if(this.num-loc.num==0) {
			return 0;
		}
		return -1;
	}
}
