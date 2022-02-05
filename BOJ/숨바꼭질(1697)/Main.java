import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[]visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		visited = new boolean[1000001];
		
		System.out.println(bfs(N, K));

	}

	static int bfs(int N, int K) {
		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(N, 0));

		Location loc = null;

		while (!queue.isEmpty()) {
			loc = queue.poll();

			if (loc.N == K)
				break;

			
			if (loc.N - 1 <= 100000 && loc.N - 1 >= 0 && !visited[loc.N - 1]) {
				visited[loc.N - 1] = true;
				queue.add(new Location(loc.N - 1, loc.count + 1));
			}
			
			if (loc.N + 1 <= 100000 && loc.N + 1 >= 0 && !visited[loc.N + 1]) {
				visited[loc.N + 1] = true;
				queue.add(new Location(loc.N + 1, loc.count + 1));
			}
			
			if (loc.N * 2 <= 100000 && loc.N * 2 >= 0 && !visited[loc.N * 2]) {
				visited[loc.N * 2] = true;
				queue.add(new Location(loc.N * 2, loc.count + 1));
			}
			

		}

		return loc.count;
	}

	static class Location {
		int N;
		int count;

		public Location(int N, int count) {
			// TODO Auto-generated constructor stub
			this.N = N;
			this.count = count;
		}
	}
}
