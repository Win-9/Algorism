import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[] coins = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            if (M >= coins[i]) {
                M -= coins[i];
                answer++;
                if (M >= coins[i]) {
                    i++;
                }
            }
        }
        System.out.println(answer);
    }
}
