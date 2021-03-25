package por;

import java.util.*;

import java.io.*;

class Main {

  static Location loc;

  static int[] x_loc={-1,1,0,0};

  static int[] y_loc={0,0,1,-1};

  static int terri=0;

  static int n;

  public static void main(String[] args) throws IOException {

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    System.out.println("n:");

    n=Integer.parseInt(br.readLine());

    boolean[][]visited=new boolean[n][n];

    Character[][]map=new Character[n][n];

    String[]str;

    for(int i=0;i<n;i++) {

    	System.out.println("line");

    	str=br.readLine().split("");

    	for(int j=0;j<n;j++) {

    		map[i][j]=str[j].charAt(0);

    	}

    }

    for(int i=0;i<n;i++) {//정상

    	for(int j=0;j<n;j++) {

    		if(!visited[i][j]) {

    			bfs(i,j,visited,map);

    			terri+=1;

    		}

    	}

    }

    for(int i = 0; i < map.length; i++) {

        Arrays.fill(visited[i], false);

    }

    System.out.print(terri+" ");

    terri=0;

    for(int i=0;i<n;i++) {//색약

    	for(int j=0;j<n;j++) {

    		if(!visited[i][j]) {

    			another_bfs(i,j,visited,map);

    			terri+=1;

    		}

    	}

    }

    System.out.print(terri);

  }

  static public void bfs(int x,int y,boolean[][]visited,Character[][]map) {

	  Queue<Location>queue=new LinkedList<>();

	  queue.add(new Location(x,y));

	  Character remember=map[x][y];

	  while(queue.size()!=0) {

		  loc=queue.poll();

		  for(int i=0;i<4;i++) {

			  int ex1=loc.x+x_loc[i];

			  int ex2=loc.y+y_loc[i];

			  if(check(ex1,ex2,visited,map)) {

				  if(!visited[ex1][ex2] && map[ex1][ex2]==remember) {

					  visited[ex1][ex2]=true;

					  queue.add(new Location(ex1,ex2));

				  }

			  }

		  }

	  }

  }

  static public void another_bfs(int x,int y,boolean[][]visited,Character[][]map) {

	  Queue<Location>queue=new LinkedList<>();

	  queue.add(new Location(x,y));

	  Character remember=map[x][y];

	  while(queue.size()!=0) {

		  loc=queue.poll();

		  for(int i=0;i<4;i++) {

			  int ex1=loc.x+x_loc[i];

			  int ex2=loc.y+y_loc[i];

			  if(check(ex1,ex2,visited,map)) {

				  if(remember!='B') {

					  if(map[ex1][ex2]!='B' && !visited[ex1][ex2]) {

						  visited[ex1][ex2]=true;

						  queue.add(new Location(ex1,ex2));

					  }

				  }

				  else {

					  if(map[ex1][ex2]=='B' && !visited[ex1][ex2]) {

						  visited[ex1][ex2]=true;

						  queue.add(new Location(ex1,ex2));

					  }

				  }

			  }

		  }

	  }

  }

  static public boolean check(int ex1,int ex2,boolean[][]visited,Character[][]map) {

	  if((ex1>=0 && ex1<n) && (ex2>=0 && ex2<n)) {//좌표이상유무

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
