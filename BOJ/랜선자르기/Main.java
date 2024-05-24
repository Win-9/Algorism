import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    static int K;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        K = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        long left = 1;
        long right = list.get(0);
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (Long num : list) {
                sum += num / mid;
            }

            if (sum >= N) {
                answer = Math.max(answer, mid);
            }

            if (sum < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("answer = " + answer);

    }
}
