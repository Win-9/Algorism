import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[]a args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        long M = Long.parseLong(str[1]);
        long[] trees = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long right = Arrays.stream(trees).max().getAsLong();
        long left = 0;
        long answer = 0;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (mid > trees[i]) {
                    continue;
                }
                sum += trees[i] - mid;
            }

            if (sum >= M) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                right = mid;
            }
        }

        System.out.println(answer);
    }
}
