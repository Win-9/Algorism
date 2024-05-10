import java.lang.*;
import java.io.*;
import java.util.*;


class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        long[] fact = new long[21];
        fact[0] = 1;

        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i;
        }

        visited = new boolean[21];
        String[] str = br.readLine().split(" ");

        int K = Integer.parseInt(str[0]);

        if (K == 1) {
            long num = Long.parseLong(str[1]);
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (fact[N - i - 1] < num) {
                        num -= fact[N - i - 1];
                    } else {
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }

            for (int i : arr) {
                System.out.print(i + " ");
            }
        } else {
            long count = 1;
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(str[i + 1]);
                for (int j = 1; j < num; j++) {
                    if (!visited[j]) {
                        count += fact[N - i - 1];
                    }
                }
                visited[num] = true;
            }
            System.out.println(count);
        }
    }
}
