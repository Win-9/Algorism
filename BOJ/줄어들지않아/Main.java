import java.lang.*;
import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int max = Collections.max(list);
        long[][] dp = new long[max + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= max; i++) {
            dp[i][1] = i;
        }

        for (int i = 2; i <= max; i++) {
            for (int j = 2; j <= 9; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        for (Integer integer : list) {
            System.out.println(Arrays.stream(dp[integer]).sum() + 1);
        }
    }
}
