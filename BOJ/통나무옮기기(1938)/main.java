package por;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Main{
	  static int[]x_loc={2,-2,0,0};
	  static int[]y_loc={0,0,2,-2};
	  static int number;
	  static int second=0;
	  static Queue<Location>queue=new LinkedList<>();
	  public static void main(String[]args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] str=br.readLine().split(" ");
	    number=Integer.parseInt(str[0]);
	    String [][]map=new String[number][number];
	    boolean[][]visited=new boolean[number][number];
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
			  if(loc.state==true) {
				  
			  }
			  for(int k=0;k<4;k++) {
				  int ex1=loc.x+x_loc[i];
				  int ex2=loc.y+y_loc[i];
				  
			  }
		  }
	  }
	  static public boolean check(boolean[][]visited,int ex1,int ex2,int[][]map){
	    if((ex1>0 && ex1<=number)&&(ex2>0 && ex2<=number)&&!visited[ex1][ex2]){
	      return true;
	    }
	    return false;
	  }
	  static public boolean turn(Location loc) {
		  
	  }
}
class Location{
	int x;
	int y;
	boolean state=true;//'-'모양
	Location(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
