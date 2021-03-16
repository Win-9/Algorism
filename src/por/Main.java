package por;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Main {
	  public static void main(String[] args) {
	    System.out.println("Hello world!");
	  }
	}
	class Solution{
	  static int[]x_loc={1,-1,0,0};
	  static int[]y_loc={0,0,1,-1};
	  static int number;
	  public void solution() throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<Integer>list=new ArrayList<>();
	    number=Integer.parseInt(br.readLine());
	    int [][]map=new int[number][number];
	    boolean[][]visited=new boolean[number][number];
	    int count=0;
	    String[]str=br.readLine().split("");
	    for(int i=0;i<number;i++){
	      for(int j=0;j<number;j++){
	        map[i][j]=Integer.parseInt(str[j]);
	      }
	    }
	    for(int i=0;i<number;i++){
	      for(int j=0;j<number;j++){
	        if(!visited[i][j]){
	          count=bfs(visited,map,i,j,count);
	        }
	      }
	    }
	  }
	  public int bfs(boolean[][]visited,int[][]map,int i,int j,int count){
	    Queue<Location>queue=new LinkedList<>();
	    queue.add(new Location(i, j));
	    visited[i][j]=true;
	    while(queue.size()!=0){
	      Location loc=queue.poll();
	      for(int k=0;k<4;k++){
	        int ex1=loc.x+x_loc[k];
	        int ex2=loc.y+y_loc[k];
	        if(check(visited,ex1,ex2,map,count)){
	          queue.add(new Location(ex1,ex2));
	        }
	      }
	    }
	    return count;
	  }
	  public boolean check(boolean[][]visited,int ex1,int ex2,int[][]map,int count){
	    if((ex1>=0 && ex1<number)&&(ex2>=0 && ex2<number)&&!visited[ex1][ex2]&& map[ex1][ex2]==1){
	      visited[ex1][ex2]=true;
	      count++;
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