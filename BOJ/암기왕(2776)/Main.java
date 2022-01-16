import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			Set<Integer> set = new HashSet<Integer>();
			StringBuilder sb = new StringBuilder();
			int M = Integer.parseInt(br.readLine());

			receive(set);
			int K = Integer.parseInt(br.readLine());

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			while (st1.hasMoreTokens()) {
				sb.append((set.contains(Integer.parseInt(st1.nextToken())) 
						? 1 : 0) + "\n");
			}
			System.out.println(sb.substring(0, sb.length()-1));

		}

	}

	static void receive(Set<Integer> set) throws IOException {
		int j = 0;
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		while (st1.hasMoreTokens()) {
			set.add(Integer.parseInt(st1.nextToken()));
		}
	}
}
