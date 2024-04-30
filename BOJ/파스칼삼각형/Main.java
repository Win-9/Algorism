import java.lang.*;
import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]) + 1;
        int k = Integer.parseInt(str[1]);

        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = 1;
        int layer = 0;

        for (int i = 2; i <= n; i++) {
            layer++;
            for (int j = 1; j <= layer; j++) {
                if (j == 1 || j == layer) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}
