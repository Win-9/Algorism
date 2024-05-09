import java.lang.*;
import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);
        int W = Integer.parseInt(str[2]);

        for (int i = 0; i < N; i++) {
            int len = Integer.parseInt(br.readLine());
            list.add(len);
        }

        int maxLength = Collections.max(list);
        long answer = 0;

        for (int i = 1; i <= maxLength; i++) {
            long sum = 0;
            for (int len : list) {
                if (i <= len) {
                    long unit = len / i;
                    long minusSum = 0;
                    if (len % i != 0) {
                        minusSum += unit;
                    } else {
                        minusSum += unit - 1;
                    }

                    long count = unit * i * W - C * minusSum;
                    if (count > 0) {
                        sum += count;
                    }
                }

            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
