import java.io.*;
import java.util.*;


public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int L;
	static int R;
	static int[] x_loc = { 1, -1, 0, 0 };
	static int[] y_loc = { 0, 0, 1, -1 };
	static boolean flag = true;
	static ArrayList<Location> locList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		int result = 0;

		while (flag) {
			flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						findBoundBfs(i, j);
						locList.clear();
					}
				}
			}

			resetVisited();
			result++;

		}

		System.out.println(result - 1);

	}
	
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	static void resetVisited() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	static void findBoundBfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(i, j));
		boolean flag2 = false;
		int count = 0;
		int sum = map[i][j];
		
		visited[i][j] = true;
		locList.add(new Location(i, j));
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = loc.x + x_loc[k];
				int y = loc.y + y_loc[k];

				if (x >= 0 && y >= 0 && x < N && y < N) {
					int gap = Math.abs(map[x][y] - map[loc.x][loc.y]);
					if (!visited[x][y] && gap >= L && gap <= R) {
						visited[x][y] = true;
						queue.add(new Location(x, y));
						locList.add(new Location(x, y));
						sum += map[x][y];
						flag = true;
						flag2 = true;
					}
				}
			}
			count++;
		}
		if (!flag2) {
			locList.clear();
			return;
		}
		
		move(count, sum);

	}

	static void move(int count, int sum) {
		int avg = sum / count;
		for(Location l : locList) {
			map[l.x][l.y] = avg;
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
