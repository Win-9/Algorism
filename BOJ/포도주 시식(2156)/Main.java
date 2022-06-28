import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[]arr = new int[N];
		int[]dp = new int[N];

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];
		
		if (N == 1) {
			System.out.println(dp[0]);
			return;
		}
		
		dp[1] = arr[1] + arr[0];

		if (N == 2) {
			System.out.println(dp[1]);
			return;
		}
		
		dp[2] = Math.max(arr[0] + arr[1], Math.max(arr[0], arr[1]) + arr[2]);
		
		for(int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 1], 
					Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]);
		}
		
		System.out.println(dp[N - 1]);
	}
	

}
