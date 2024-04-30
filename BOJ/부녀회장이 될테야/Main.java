import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[k + 1][n + 1];
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }

            for (int j = 1; j <= k; j++) {
                for (int s = 1; s <= n; s++) {
                    if ( s == 1) {
                        dp[j][s] = 1;
                        continue;
                    }
                    dp[j][s] = dp[j][s - 1] + dp[j - 1][s];
                }
            }

            System.out.println(dp[k][n]);
        }


    }
} 
