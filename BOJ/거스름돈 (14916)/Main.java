import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		
		if (N < 6) {
			dp = new int[6];
		}
		
		Arrays.fill(dp, -1);
		
		
		dp[1] = -1;
		dp[2] = 1;
		dp[3] = -1;
		dp[4] = 2;
		dp[5] = 1;
		
		for(int i = 6; i <= N; i++) {
			dp[i] = dp[i - 2] + 1;
			if (i % 5 == 0) {
				dp[i] = dp[i - 5] + 1;
			}
		}
		
		System.out.println(dp[N]);
	}
}
