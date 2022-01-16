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
		int N = Integer.parseInt(br.readLine());
		Hashtable<String, Integer> map = new Hashtable<>();
		for (int i = 0; i < N; i++) {
			String key = br.readLine();
			if (map.containsKey(key)) {
				int num = map.get(key);
				map.put(key, ++num);
				continue;
			}
			map.put(key, 1);
		}
		int max = 0;
		String answer = "";
		for (String s: map.keySet()) {

			if (map.get(s) == max && answer.compareTo(s) > 0) {
				answer = s;
				continue;
			}
			
			if (map.get(s) > max) {
				max = map.get(s);
				answer = s;
			}
		}
		
		System.out.println(answer);

	}
}
