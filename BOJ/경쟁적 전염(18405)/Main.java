/*
NxN 크기의 시험관이 있다. 시험관은 1x1 크기의 칸으로 나누어지며, 특정한 위치에는 바이러스가 존재할 수 있다. 모든 바이러스는 1번부터 K번까지의 바이러스 종류 중 하나에 속한다.

시험관에 존재하는 모든 바이러스는 1초마다 상, 하, 좌, 우의 방향으로 증식해 나간다. 단, 매 초마다 번호가 낮은 종류의 바이러스부터 먼저 증식한다. 또한 증식 과정에서 특정한 칸에 이미 어떠한 바이러스가 존재한다면, 그 곳에는 다른 바이러스가 들어갈 수 없다.

시험관의 크기와 바이러스의 위치 정보가 주어졌을 때, S초가 지난 후에 (X,Y)에 존재하는 바이러스의 종류를 출력하는 프로그램을 작성하시오. 만약 S초가 지난 후에 해당 위치에 바이러스가 존재하지 않는다면, 0을 출력한다. 이 때 X와 Y는 각각 행과 열의 위치를 의미하며, 시험관의 가장 왼쪽 위에 해당하는 곳은 (1,1)에 해당한다.

예를 들어 다음과 같이 3x3 크기의 시험관이 있다고 하자. 서로 다른 1번, 2번, 3번 바이러스가 각각 (1,1), (1,3), (3,1)에 위치해 있다. 이 때 2초가 지난 뒤에 (3,2)에 존재하는 바이러스의 종류를 계산해보자.
*/
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
	    int k=Integer.parseInt(str[1]);
	    int [][]map=new int[number+1][number+1];
	    boolean[][]visited=new boolean[number+1][number+1];
	    int last_x=0;int last_y=0;
	    for(int i=1;i<=number+1;i++){
	      str=br.readLine().split(" ");
	      for(int j=0;j<number;j++){
	    	  if(i==number+1) {
	    		  second=Integer.parseInt(str[0]);
	    		  last_x=Integer.parseInt(str[1]);
	    		  last_y=Integer.parseInt(str[2]);
	    		  break;
	    	  }
	    	  map[i][j+1]=Integer.parseInt(str[j]);
	      }
	    }
	    for(int i=1;i<number+1;i++){
	      for(int j=1;j<number+1;j++){
	        if(!visited[i][j] && map[i][j]!=0){
	          add_list.add(new Location(i,j,map[i][j],0));
	        }
	      }
	    }
	    Collections.sort(add_list);
	    for(int i=0;i<add_list.size();i++) {
	    	queue.add(add_list.get(i));
	    }
	    bfs(visited,map,add_list.get(0).x,add_list.get(0).y);
	    if(map[last_x][last_y]==0) {
	    	System.out.println("0");
	    }
	    else {
	    	System.out.println(map[last_x][last_y]);
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
