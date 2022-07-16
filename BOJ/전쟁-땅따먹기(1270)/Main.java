import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseUnsignedLong(br.readLine());
		
		for(long i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashMap<Long, Long> map = new HashMap<>();
			long max = Long.parseUnsignedLong(st.nextToken()); // 맨앞의 하나 빼줌
			
			while(st.hasMoreTokens()) {
				long num = Long.parseUnsignedLong(st.nextToken());
				map.put(num, map.getOrDefault(num, (long) 0) + 1);
			}
			func(max, map);
			System.gc();
		}

	}
	
	static void func(long num, HashMap<Long, Long> map) {
		long half = num/2;
				
		for (long i : map.keySet()) {
			long m = map.get(i);
			if (half < m) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println("SYJKGW");
		
	}
}
