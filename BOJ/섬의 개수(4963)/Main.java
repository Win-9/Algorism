import java.io.*;
import java.util.*;

public class Main {
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] x_loc = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] y_loc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int count = 0;
			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j, visited);
						count++;
					}
				}
			}
			sb.append(count).append("\n");

		}

		System.out.println(sb);

	}

	static void bfs(int i, int j, boolean[][] visited) {
		Queue<Location> queue = new LinkedList<>();
		visited[i][j] = true;

		queue.add(new Location(i, j));

		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			for (int k = 0; k < 8; k++) {
				int x = loc.x + x_loc[k];
				int y = loc.y + y_loc[k];
				if (x >= 0 && y >=0 && x < h && y < w) {
					if (map[x][y] == 1 && !visited[x][y]) {
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
