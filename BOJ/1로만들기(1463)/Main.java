
import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		System.out.println(bfs(N));

			
			
		}

	}

	static int bfs(int N) {
		Queue<Count> queue = new LinkedList<>();
		queue.add(new Count(N, 0));
		Count w = null;
		while (!queue.isEmpty()) {
			w = queue.poll();
			if (w.N == 1)
				break;

			int num = w.N % 3;
			if (num == 0 && !visited[w.N / 3]) {
				visited[w.N / 3] = true;
				queue.add(new Count(w.N / 3, w.count + 1));
			}

			num = w.N % 2;

			if (num == 0 && !visited[w.N / 2]) {
				visited[w.N / 2] = true;
				queue.add(new Count(w.N / 2, w.count + 1));
			}

			num = w.N - 1;

			if (num >= 0 && !visited[w.N - 1]) {
				visited[w.N - 1] = true;
				queue.add(new Count(w.N - 1, w.count + 1));
			}

		}

		return w.count;
	}

	static class Count {
		int N;
		int count;

		public Count(int N, int count) {
			// TODO Auto-generated constructor stub
			this.N = N;
			this.count = count;
		}
	}

}
