import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			int[]coin = new int[num + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= num; j++) {
				coin[j] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			
			func(coin, M, num);
		}

	}

	static void func(int[] coin, int M, int num) {
		// TODO Auto-generated method stub
		int[]dp = new int[M + 1];
		dp[0] = 1;
		
		for(int i = 1; i <= num; i++) {
			for(int j = coin[i]; j <= M; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		
		System.out.println(dp[M]);
		
	}

}
