import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int sum;
    static String[] combine = new String[3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sum = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            combine = new String[3];

            String[] arr = br.readLine().split(" ");
            collect(arr, 0, 0);
            System.out.println(sum);
        }
    }

    static void collect(String[] arr, int start, int depth) {
        if (depth == 3) {
            sum = Math.min(sum, compare(combine));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            combine[depth] = arr[i];
            collect(arr, i + 1, depth + 1);
            if (sum == 0) {
                return;
            }
        }
    }

    static int compare(String[] arr) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[0].charAt(i) != arr[1].charAt(i)) {
                sum++;
            }

            if (arr[1].charAt(i) != arr[2].charAt(i)) {
                sum++;
            }

            if (arr[0].charAt(i) != arr[2].charAt(i)) {
                sum++;
            }
        }
        return sum;
    }
}
