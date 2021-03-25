package por;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Main{
	  static int[]case1_x_loc={2,-2,0,0};
	  static int[]case1_y_loc={0,0,1,-1};
	  static int[]case2_x_loc={1,-1,0,0};
	  static int[]case2_y_loc={0,0,2,-2};
	  static int number;
	  static int second=0;
	  static boolean contact=false;
	  static Queue<Location>queue=new LinkedList<>();
	  public static void main(String[]args) throws Exception{
		Location[]start=new Location[3];
		Location[]end=new Location[3];
		int count=0;int count2=0;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] str=br.readLine().split(" ");
	    number=Integer.parseInt(str[0]);
	    String [][]map=new String[number][number];
	    boolean[][]visited=new boolean[number][number];
	    for(int i=0;i<number+1;i++){
	      str=br.readLine().split(" ");
	      for(int j=0;j<number;j++){
	    	  map[i][j]=str[j];
	    	  System.out.println("j:"+j);
	    	  if(str[j].equals("B")) {
	    		  start[count]=new Location(i,j);
	    		  ++count;
	    		  System.out.println("악!");
	    	  }
	    	  else if(str[j].equals("E")) {
	    		  end[count2]=new Location(i,j);
	    		  ++count2;
	    	  }
	      }
	    }
	    if(start[1].x==start[0].x-1) {
	    	count=bfs(visited,map,start[1].x,start[1].y,true,end[1].x,end[1].y);
	    }
	    else {
	    	count=bfs(visited,map,start[1].x,start[1].y,false,end[1].x,end[1].y);
	    }
	    System.out.println(count);
	    
	  }
	  static public int bfs(boolean[][]visited,String[][]map,int i,int j,
			  boolean state,int end1,int end2){
		  visited[i][j]=true;
		  Location loc=null;
		  queue.add(new Location(i,j,state,0));
		  while(queue.size()!=0) {
			  loc=queue.poll();
			  if(loc.x==end1 && loc.y==end2) {
				  return loc.count;
			  }
			  if(turn(loc,map)) {
				  loc.state=!loc.state;
				  queue.add(new Location(loc.x, loc.y,loc.state,loc.count));
			  }
			  if(loc.state==true) {
				  for(int k=0;k<4;k++) {
					  int ex1=loc.x+case1_x_loc[k];
					  int ex2=loc.x+case1_y_loc[k];
					  if(check(visited,ex1,ex2,map)) {
						  if(case1_x_loc[k]<0)
						  {
							  visited[ex1+1][ex2]=true;
							  queue.add(new Location(ex1+1, ex2,loc.state,loc.count+1));
						  }
						  else {
							  visited[ex1-1][ex2]=true;
							  queue.add(new Location(ex1-1, ex2,loc.state,loc.count+1));
						  }
					  }
				  }
			  }
			  else {
				  for(int k=0;k<4;k++) {
					  int ex1=loc.x+case2_x_loc[k];
					  int ex2=loc.x+case2_y_loc[k];
					  if(check(visited,ex1,ex2,map)) {
						  if(case2_x_loc[k]<0)
						  {
							  visited[ex1+1][ex2]=true;
							  queue.add(new Location(ex1+1, ex2,loc.state,loc.count+1));
						  }
						  else {
							  visited[ex1-1][ex2]=true;
							  queue.add(new Location(ex1-1, ex2,loc.state,loc.count+1));
						  }
					  }
				  }
			  }
		  }
		  return 0;
	  }
	  static public boolean check(boolean[][]visited,int ex1,int ex2,String[][]map){
	    if((ex1>=0 && ex1<number)&&(ex2>=0 && ex2<number)&&!visited[ex1][ex2]
	    		&& !map[ex1][ex2].equals("1")){
	      return true;
	    }
	    return false;
	  }
	  static public boolean turn(Location loc,String[][]map) {
		  if(loc.state==true) {
			  for(int i=loc.y-1;i<3;i++) {
				  for(int j=loc.x-1;j<3;j++) {
					  if(i==loc.y && j==loc.x) {continue;}
					  if(!map[i][j].equals("0")) {
						  return false;
					  }
				  }
			  }
			  return true;
		  }
		  else {
			  for(int i=loc.y-1;i<3;i++) {
				  for(int j=loc.x-1;j<3;j++) {
					  if(i==loc.y && j==loc.x) {continue;}
					  if(!map[i][j].equals("0")) {
						  return false;
					  }
				  }
			  }
			  return true;
		  }
	  }
}
class Location{
	int x;
	int y;
	boolean state=true;//'-'모양
	int count;
	Location(int x,int y,boolean state,int count){
		this.x=x;
		this.y=y;
		this.state=state;
		this.count=count;
	}
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
