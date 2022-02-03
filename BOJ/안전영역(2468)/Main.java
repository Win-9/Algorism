import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int[] x_loc = {1, -1, 0, 0};
	static int[] y_loc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int max = 0;
		int result = 0;
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (max < map[i][j]) {
					max = map[i][j];
				}
			}
		}
		int count = 0;
		while(count < max) {
			for(int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
			
			int maxLocation = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if (map[i][j] > count && !visited[i][j]) {
						bfs(i,j,count);
						maxLocation++;
					}
				}
			}
			
			
			if (result < maxLocation) {
				result = maxLocation;
			}
			count++;
		}
		
		System.out.println(result);
		

	}
	
	static void bfs(int i, int j, int count) {
		visited[i][j] = true;
		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(i, j));
		while(!queue.isEmpty()){
			Location loc = queue.poll();
			
			for(int k = 0; k < 4; k++) {
				int x = x_loc[k] + loc.x;
				int y = y_loc[k] + loc.y;

				if (x >= 0 && y >= 0 && x < N && y < N) {
					if (map[x][y] > count && !visited[x][y]) {
						visited[x][y] = true;
						queue.add(new Location(x,y));
					}
				}
			}
			
		}
	}

	static class Location {
		int x;
		int y;

		public Location(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}
}
