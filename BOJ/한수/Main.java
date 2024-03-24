import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if (num < 100) {
            System.out.println(num);
            return;
        }

        int result = 99;

        for(int i = 100; i <= num; i++) {
            if (isContinue(i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean isContinue(int num) {
        int[] arr = Arrays.stream((num + "").split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        return (arr[0] + arr[2]) == arr[1] * 2;
    }
}
