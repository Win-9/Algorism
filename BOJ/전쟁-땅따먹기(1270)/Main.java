import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();
			int max = Integer.parseInt(st.nextToken()); // 맨앞의 하나 빼줌
			
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			func(max, map);
		}

	}
	
	static void func(int num, HashMap<Integer, Integer> map) {
		int half = num/2;
				
		for (int i : map.keySet()) {
			int m = map.get(i);
			if (half < m) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println("SYJKGW");
		
	}
}
