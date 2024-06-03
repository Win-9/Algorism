import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        Item[] items = new Item[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i < N + 1; i++) {
            str = br.readLine().split(" ");
            items[i] = new Item(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (items[i].w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], items[i].v + dp[i - 1][j - items[i].w]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
