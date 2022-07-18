import java.util.*;
import java.io.*;

class Main {
	static int result = 0;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>list[] = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int j = 0;
		int root = 0;
		while(st.hasMoreTokens()) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				root = j;
				j++;
				continue;
			}
			list[parent].add(j++);
		}
		
		for(int i = 0; i < N; i++) {
			Collections.sort(list[i]);
		}

				
		int except = Integer.parseInt(br.readLine());
		
		if (except == root) {
			System.out.println(0);
			return;
		}
		
		delete(list, except, root);
		
		System.out.println(result);
		
	}
	
	static void delete(List<Integer>list[], int except, int start) {
		Queue<Integer> queue = new LinkedList<>();
				
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int m = queue.poll();
			int count = 0;

			for(Integer node: list[m]) {
				if(node != except) {
					queue.add(node);
					count++;
				}
			}
			
			if(count == 0) {
				result++;
			}
		}		
	}
}
