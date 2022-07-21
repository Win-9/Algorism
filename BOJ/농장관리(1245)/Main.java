import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int M;
	static int[]x_move = {-1,-1,-1,0,0,1,1,1};
	static int[]y_move = {-1,0,1,-1,1,-1,0,1};
	static boolean is_high = true;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][]map = new int[N + 1][M + 1];
		boolean[][]visited = new boolean[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 1;
			while(st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if (!visited[i][j]) {
					bfs(map, visited, i, j);
					
					if (is_high) {
						result ++;
					}
					
					is_high = true;
				}
			}
		}
		
		System.out.println(result);
				
		
	}
	
	static void bfs(int[][]map, boolean[][]visited, int x, int y) {
		int num = map[x][y];
		Queue<Loc> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.add(new Loc(x,y));
		
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int x_loc = loc.x + x_move[i];
				int y_loc = loc.y + y_move[i];
				
				if (valid(x_loc, y_loc) && map[x_loc][y_loc] > num) {
					is_high = false;
				}
				
				if (valid(x_loc, y_loc) && !visited[x_loc][y_loc] && map[x_loc][y_loc] == num) {
					visited[x_loc][y_loc] = true;
					queue.add(new Loc(x_loc, y_loc));
				}
				
			}
		}
	}
	
	static boolean valid(int x, int y) {
		if (x > 0 && x <= N && y > 0 && y <= M) {
			return true;
		}
		return false;
	}
	
	static class Loc{
		int x;
		int y;
		public Loc(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
