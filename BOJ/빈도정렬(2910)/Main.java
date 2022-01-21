import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			int key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
				continue;
			}
			map.put(key, 1);
		}
		
		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 < o2 ? -1 : o1 == o2 ? 0 : 1;
			}
		});

		for (int a : list) {
			for (int i = 0; i < map.get(a); i++) {
				sb.append(a).append(" ");
			}
		}
		
		System.out.println(sb);
	}

}
