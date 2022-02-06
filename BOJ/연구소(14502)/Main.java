import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int[] x_loc = { 1, -1, 0, 0 };
	static int[] y_loc = { 0, 0, 1, -1 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		wall(0);
		
		System.out.println(max);

	}

	static void wall(int count) {

		if (count == 3) {
			max = Math.max(max, bfs());
			resetVisited();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					wall(count + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void printMap(int [][]map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void resetVisited() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	static int bfs() {
		Queue<Location> queue = new LinkedList<>();
		int[][]map2 = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map2[i][j] = map[i][j];
				if (map[i][j] == 2) {
					visited[i][j] = true;
					queue.add(new Location(i, j));	
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Location loc = queue.poll();
			for(int i = 0; i < 4; i++) {
				int x = loc.x + x_loc[i];
				int y = loc.y + y_loc[i];
				
				if (x >= 0 && y >= 0 && x < N && y < M) {
					if (!visited[x][y] && map2[x][y] == 0) {
						visited[x][y] = true;
						map2[x][y] = 2;
						queue.add(new Location(x, y));
					}
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map2[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
		
		
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
