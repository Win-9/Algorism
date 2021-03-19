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
	    for(int i=0;i<=number+1;i++){
	      str=br.readLine().split(" ");
	      for(int j=0;j<number;j++){
	    	  map[i][j]=str[j];
	      }
	    }
	  }
	  static public void bfs(boolean[][]visited,int[][]map,int i,int j){
		  Queue<All_Location>queue=new LinkedList<>();
		  visited[i][j]=true;
		  while(queue.size()!=0) {
			  if(turn()) {
				  
			  }
			  All_Location loc=queue.poll();
			  for(int k=0;k<4;k++) {
				  int ex1=loc.l1.getX()+x_loc[i];
				  int ex2=loc.l1.getY()+y_loc[i];
				  int ex3=loc.l2.getX()+x_loc[i];
				  int ex4=loc.l2.getY()+y_loc[i];
				  int ex5=loc.l3.getX()+x_loc[i];
				  int ex6=loc.l3.getY()+y_loc[i];
				  if(check(visited,ex1,ex2,map) && check(visited,ex3,ex4,map)
						  &&check(visited,ex5,ex6,map)) {
					  visited[ex1][ex2]=true;
					  visited[ex3][ex4]=true;
					  visited[ex5][ex6]=true;
					  map[ex1][ex2]=loc.num;
					  queue.add(new All_Location(new Location(ex1,ex2),
							  new Location(ex3,ex4), new Location(ex5,ex6)));  
				  }
			  }
		  }
	  }
	  static public boolean check(boolean[][]visited,int ex1,int ex2,int[][]map){
	    if((ex1>0 && ex1<=number)&&(ex2>0 && ex2<=number)&&!visited[ex1][ex2]){
	      return true;
	    }
	    return false;
	  }
	  static public boolean turn() {
		  
	  }
}
class All_Location{
	Location l1;
	Location l2;
	Location l3;
	int count=0;
	boolean shape=true;//'-'모양
	All_Location(Location l1,Location l2,Location l3){
		this.l1=l1;
		this.l2=l2;
		this.l3=l3;
		++count;
	}
}
class Location{
	int x;
	int y;
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
