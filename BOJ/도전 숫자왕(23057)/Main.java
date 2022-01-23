import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static TreeSet<Integer> set = new TreeSet<>();
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int M = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			M += num;
		}

		combination(arr, 0, 0, N);

		System.out.println(M - set.size() + 1);

	}

	static void combination(int[]arr, int sum, int idx, int N) {
		
		set.add(sum);

		if (idx == N) {
			return;
		}
				
		combination(arr, sum + arr[idx], idx+1, N);
		combination(arr, sum, idx + 1, N);
	}

}
