package por;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.Arrays;

import java.util.LinkedList;

import java.util.Queue;

class Main {

	static int count_x;

	static int count_y;

	static int r;

	static int c;

	static int []x_loc= {1,-1,0,0};

	static int []y_loc= {0,0,1,-1};

	static int [][]count_map;

	static boolean meet=false;

	public static void main(String[]args) throws IOException {

		Queue<Location>queue=new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[]str=br.readLine().split(" ");

		int r=Integer.parseInt(str[0]);

		int c=Integer.parseInt(str[1]);

		String[][]map=new String[r][c];

		count_map=new int[r][c];

		for(int i = 0; i < count_map.length; i++) {

            Arrays.fill(count_map[i], 0);

        }

		boolean[][]visited=new boolean[r][c];

		for(int i=0;i<r;i++) {

			str=br.readLine().split("");

			if(str==null) {

				break;

			}

			for(int j=0;j<c;j++) {

				map[i][j]=str[j];

				if(map[i][j].equals("*")) {

					queue.add(new Location(i,j));

					visited[i][j]=true;

				}

				else if(map[i][j].equals("D")) {

					count_x=i;

					count_y=j;

				}

			}

		}

		for(int i=0;i<r;i++) {

			for(int j=0;j<c;j++) {

				if(map[i][j].equals("S")) {

					queue.add(new Location(i,j));

					visited[i][j]=true;

				}

			}

		}

		bfs(queue,visited,map);

		if(meet==false) {

			System.out.println("KAKTUS");

		}

		else {

			System.out.println(count_map[count_x][count_y]);

		}

	}

	static public void bfs(Queue<Location>queue,boolean[][]visited,String[][]map) {

		while(queue.size()!=0) {

			Location loc=queue.poll();

			for(int i=0;i<4;i++) {

				int ex1=loc.x+x_loc[i];

				int ex2=loc.y+y_loc[i];

				if(map[loc.x][loc.y].equals("S") && check2(ex1,ex2,visited,map)) {//비버일때

					if(map[ex1][ex2].equals("D")) {meet=true;}

					map[ex1][ex2]="S";

					count_map[ex1][ex2]=count_map[loc.x][loc.y]+1;

					visited[ex1][ex2]=true;

					queue.add(new Location(ex1,ex2));

				}

				else if(check1(ex1,ex2,visited,map)) {//물일때

					visited[ex1][ex2]=true;

					queue.add(new Location(ex1,ex2));

				}

			}

		}

	}

	static public boolean check1(int x,int y,boolean[][]visited,String[][]map) {

		if((x>=0 && x<map.length) && (y>=0 && y<map[0].length)

				&& !visited[x][y] && !map[x][y].equals("X")

				&& !map[x][y].equals("D")) {//물

			return true;

		}

		return false;

	}

	static public boolean check2(int x,int y,boolean[][]visited,String[][]map) {

		if((x>=0 && x<map.length) && (y>=0 && y<map[0].length) && !map[x][y].equals("X") && 

				!visited[x][y]) {//비버

			if(!map[x][y].equals("X") && 

				!visited[x][y]) {

				return true;

			}

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
