import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[1] = 0;

		for (int i = 1; i <= N; i++) {

			if (dp[i] == Integer.MAX_VALUE)
				continue;

			int num = arr[i];

			for (int j = 1; j <= num; j++) {

				if (j + i > N)
					continue;

				dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
			}
		}

		if (dp[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}
}
