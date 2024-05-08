import java.lang.*;
import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long X = Long.parseLong(str[0]);
        long Y = Long.parseLong(str[1]);

        long answer = -1;
        long left = 0;
        long right = 1000000000;
        long Z = Y * 100 / X;

        while (left <= right) {
            long mid = (left + right) / 2;
            long rate = (Y + mid) * 100 / (X + mid);
            if (rate != Z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
