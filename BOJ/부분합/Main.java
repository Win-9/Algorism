import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int[] arr = new int[N + 1];
        int left = 0;
        int right = 0;
        int length = N + 1;
        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int sum = 0;

        while (left <= N && right <= N) {
            if (sum >= S && length > right - left) {
                length = right - left;
            }

            if (sum < S) {
                sum += arr[right++];
            } else {
                sum -= arr[left++];
            }
        }

        if (length == N + 1) {
            System.out.println(0);
            return;
        }
        System.out.println(length);
    }

}

