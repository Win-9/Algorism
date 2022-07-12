import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, Integer> map = new LinkedHashMap<>();
		
		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), i + 1);
		}
		List<String> list = new ArrayList<>(map.keySet());
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if (isNumber(str)) {
				System.out.println(list.get(Integer.parseInt(str) - 1));
				continue;
			}
			
			System.out.println(map.get(str));

		}

	}
	
	static boolean isNumber(String str) {
		if (Character.isDigit(str.charAt(0))) {
			return true;
		}
		
		return false;
	}

}
