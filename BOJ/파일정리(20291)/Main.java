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
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(),".");
			st.nextToken();//버려줌
			String key = st.nextToken();
			if (map.containsKey(key)) {
				map.replace(key, map.get(key) + 1);
				continue;
			}
			map.put(key, 1);
		}
		
		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				
				return o1.compareTo(o2) > 0 ? 1 :
					o1.compareTo(o2) == 0 ? 0 : -1;
			}
		});
		
		for (String a : list) {
			sb.append(a).append(" ").append(map.get(a)).append("\n");
		}
		System.out.println(sb);
	}

}
