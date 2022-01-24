import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int key = Integer.parseInt(st.nextToken());
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
			int num = func(map,K);
			if (num != -1) {
				sb.append(num).append("\n");
				continue;
			}
			sb.append("SYJKGW").append("\n");
			
		}
		System.out.println(sb);
	}
	
	static int func(HashMap<Integer, Integer> map, int K) {
		
		for (int key : map.keySet()) {
			
			if (map.get(key) == K/2 && map.size() == 2) {
				return -1;
			}
			
			if (map.get(key) >= K/2) {
				return key;
			}
		}
		
		return -1;
	}
}
