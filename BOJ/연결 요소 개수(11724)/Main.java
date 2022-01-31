import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N + 1];
		int count = 0;
		LinkedList<Integer>[] list = new LinkedList[N + 1];
		
		for (int i = 0; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		for (int i = 0; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i, list, visited);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	static void bfs(int V, LinkedList<Integer>[] list, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[V] = true;

		queue.add(V);
		
		while (!queue.isEmpty()) {
			V = queue.poll();
			Iterator<Integer> iter = list[V].listIterator();
			
			while(iter.hasNext()) {
				int w = iter.next();
				if (!visited[w]) {
					visited[w] = true;
					queue.add(w);
				}
			}
		}
		
	}
	
}
