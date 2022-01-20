import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int count = 0;
		char[][] strArr = new char[R][C];

		for (int i = 0; i < R; i++) {
			strArr[i] = br.readLine().toCharArray();
		}

		String[] Rstr = new String[C];
		for (int j = 0; j < C; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < R; i++) {
				sb.append(strArr[i][j]);
			}
			Rstr[j] = sb.toString();
		}

		for (int i = 0; i < R; i++) {
			HashSet<String> set = new HashSet<>();
			for (int j = 0; j < C; j++) {
				String ex = Rstr[j];
				if (set.contains(ex.substring(i))) {
					System.out.println(count - 1);
					return;
				}
				set.add(ex.substring(i));
			}
			count++;
		}
		
		System.out.println(count - 1);

	}

}
