import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
        HashMap<String, Num> map = new HashMap<>();
        long sum = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	String key = st.nextToken();
        	if(n == 1) {
        		map.put(key, map.getOrDefault(key, new Num()));
        		map.get(key).add(st);
        		continue;
        	}
        	int k = Integer.parseInt(st.nextToken());
        	if (map.containsKey(key)) {
        		sum += map.get(key).get(k);
        	}
        	
        }
        System.out.println(sum);
        
    }
}

class Num {
	PriorityQueue<Long> queue;

	public Num() {
		queue = new PriorityQueue<>(Collections.reverseOrder());
	}

	public void add(StringTokenizer st) {
		int i = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
			queue.add(Long.parseLong(st.nextToken()));
		}
	}

	public long get(int k) {
		long sum = 0;

		for (int i = 0; i < k; i++) {
			if (queue.size() == 0) {
				break;
			}
			sum += queue.poll();
		}
		
		return sum;
	}
}
