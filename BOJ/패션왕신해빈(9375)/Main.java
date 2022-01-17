import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int k = 0; k < N; k++) {
			Hashtable<String, Integer> map = new Hashtable<>();
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) { // Table에 정보삽입
				String[] str = br.readLine().split(" ");
				if (map.containsKey(str[1])) {
					int num = map.get(str[1]);
					map.put(str[1], ++num);
					continue;
				}
				map.put(str[1], 1);
			}
			sb.append(combine(map) + "\n");
		}
		System.out.println(sb.substring(0, sb.length() - 1));
	}

	static int combine(Hashtable<String, Integer> map) {
		int sum = 1;
		for (int i : map.values()) {
			sum *= i + 1;
		}

		return sum - 1;
	}

}
