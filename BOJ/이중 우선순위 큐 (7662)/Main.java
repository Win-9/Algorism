import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.reverseOrder());
			problem(Integer.parseInt(br.readLine()), map);
			if (map.size() == 0) {
				sb.append("EMPTY").append("\n");
				continue;
			}
			sb.append(map.firstKey()).append(" " + map.lastKey()).append("\n");
		}

		System.out.println(sb);
	}

	static void problem(int T, TreeMap<Integer, Integer> map) throws IOException {
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			switch (order) {
			case "I":
				map.put(num, map.getOrDefault(num, 0) + 1);
				break;
			case "D":
				if (map.size() == 0)
					break;

				if (num == 1) {
					if (map.get(map.firstKey()) == 1) {
						map.remove(map.firstKey());
					} else {
						map.replace(map.firstKey(), map.get(map.firstKey()) - 1);
					}
				} else {
					if (map.get(map.lastKey()) == 1) {
						map.remove(map.lastKey());
					} else {
						map.replace(map.lastKey(), map.get(map.lastKey()) - 1);
					}
				}
				break;
			}
		}
	}
}
