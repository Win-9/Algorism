import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];

		if (N < 3) {
			arr = new int[4];
			dp = new int[4];
		}


		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = dp[1] + arr[2];
		dp[3] = Math.max(arr[2] + arr[3], arr[1] + arr[3]);
		
		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i] + arr[i - 1], dp[i - 2] + arr[i]);
		}

		System.out.println(dp[N]);

	}
}
