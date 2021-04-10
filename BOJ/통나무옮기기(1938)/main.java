이와 같은 방식으로 이동시킬 때에 그 움직일 위치에 다른 나무, 즉 1이 없어야만 움직일 수 있다. 그리고 움직임은 위의 그림과 같이 한 번에 한 칸씩만 움직인다. 단 움직이는 통나무는 어떤 경우이든지 중간단계에서 한 행이나 한 열에만 놓일 수 있다. 예를 들면 아래 그림에서 a와 같은 단계는 불가능하다. 그리고 회전의 경우에서는 반드시 중심점을 중심으로 90도 회전을 해야 한다. (항상 통나무의 길이가 3이므로 중심점이 있음)

그리고 이런 회전(Turn)이 가능하기 위해서는 그 통나무를 둘러싸고 있는 3*3 정사각형의 구역에 단 한 그루의 나무도 없어야만 한다. 즉, 아래그림 b, d와 같이 ?로 표시된 지역에 다른 나무, 즉 1이 없어야만 회전시킬 수 있다. 따라서 c와 같은 경우에, 통나무는 왼쪽 아직 벌채되지 않은 나무 때문에 회전시킬 수 없다.

a	b	c	d
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 B 0 0
0 0 B 0 0 0
0 B 0 0 0 0
0 0 0 1 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 ? ? ? 0
0 0 B B B 0
0 0 ? ? ? 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 B 0 0
0 0 0 B 0 0
0 0 0 B 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 ? B ? 0
0 0 ? B ? 0
0 0 ? B ? 0
0 0 0 0 0 0
문제는 통나무를 5개의 기본동작(U, D, L, R, T)만을 사용하여 처음위치(BBB)에서 최종위치(EEE)로 옮기는 프로그램을 작성하는 것이다. 단, 최소 횟수의 단위 동작을 사용해야 한다.

	
	
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
	    String str=br.readLine();
	    number=Integer.parseInt(str);
	    String [][]map=new String[number][number];
	    boolean[][]visited=new boolean[number][number];
	    for(int i=0;i<number;i++){
	      str=br.readLine();
	      for(int j=0;j<number;j++){
	    	  map[i][j]=Character.toString(str.charAt(j));
	    	  if(Character.toString(str.charAt(j)).equals("B")) {
	    		  start[count]=new Location(i,j);
	    		  ++count;
	    	  }
	    	  else if(Character.toString(str.charAt(j)).equals("E")) {
	    		  end[count2]=new Location(i,j);
	    		  ++count2;
	    	  }
	      }
	    }
	    if(start[1].x==start[0].x-1) {//'|'shape
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
					  if(check_A(visited,ex1,ex2,map)) {//'-'shape
						  System.out.println("A:ex1:"+ex1+" ex2:"+ex2);
						  if(case1_x_loc[k]<0)
						  {
							  visited[ex1+1][ex2]=true;
							  queue.add(new Location(ex1+1, ex2,loc.state,loc.count+1));
						  }
						  else if(case1_x_loc[k]>0){
							  visited[ex1-1][ex2]=true;
							  queue.add(new Location(ex1-1, ex2,loc.state,loc.count+1));
						  }
						  else {//'y'이동
							  visited[ex1][ex2]=true;
							  queue.add(new Location(ex1, ex2,loc.state,loc.count+1));
						  }
					  }
				  }
			  }
			  else {
				  for(int k=0;k<4;k++) {
					  int ex1=loc.x+case2_x_loc[k];
					  int ex2=loc.y+case2_y_loc[k];
					  if(check_B(visited,ex1,ex2,map)) {//'|'shape
						  System.out.println("B:ex1:"+ex1+" ex2:"+ex2);
						  if(case2_y_loc[k]<0)
						  {
							  visited[ex1][ex2+1]=true;
							  queue.add(new Location(ex1, ex2+1,loc.state,loc.count+1));
						  }
						  else if(case2_y_loc[k]>0) {
							  visited[ex1][ex2-1]=true;
							  queue.add(new Location(ex1, ex2-1,loc.state,loc.count+1));
						  }
						  else {//'x'이동
							  visited[ex1][ex2]=true;
							  queue.add(new Location(ex1, ex2,loc.state,loc.count+1));
						  }
					  }
				  }
				  System.out.println("=======");
			  }
		  }
		  return 0;
	  }
	  static public boolean check_A(boolean[][]visited,int ex1,int ex2,String[][]map){
	    if((ex1>0 && ex1<number-1)&&(ex2>=0 && ex2<number)&&!visited[ex1][ex2]
	    		&& !map[ex1][ex2].equals("1")){
	      return true;
	    }
	    return false;
	  }//가로이동
	  static public boolean check_B(boolean[][]visited,int ex1,int ex2,String[][]map){
		 if((ex1>=0 && ex1<number)&&(ex2>0 && ex2<number-1)&&!visited[ex1][ex2]
		    	&& !map[ex1][ex2].equals("1")){
		      return true;
		  }
		    return false;
	  }//세로이동
	  static public boolean turn(Location loc,String[][]map) {
		  System.out.println("state:"+loc.state+" xy:"+loc.x+" "+loc.y);
		  if(loc.state==true) {
			  int i=loc.y-1;
			  int j=loc.x-1;
			  for(int s1=0;s1<3;s1++) {
				  for(int s2=0;s2<3;s2++) {
					  if(i==loc.y && j==loc.x) {continue;}
					  if((j-1<0) || (j+1)>number-1 || map[i][j].equals("1")) {
						  return false;
					  }
					  j++;
				  }
				  i++;
			  }
			  return true;
		  }
		  else {
			  int i=loc.x-1;
			  int j=loc.y-1;
			  for(int s1=0;s1<3;s1++) {
				  for(int s2=0;s2<3;s2++) {
					  if((i-1<0) || (i+1)>number-1 || map[i][j].equals("1")) {
						  return false;
					  }
					  j++;
				  }
				  i++;
			  }
			  return true;
		  }
	  }
}
class Location{
	int x;
	int y;
	boolean state=true;//'-'shape
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
