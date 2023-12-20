import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] operator;
    static int[] numbers;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        operator = new int[4];
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(str[i]);
        }

        str = br.readLine().split(" ");
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(str[i]);
        }

        trace(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    static void trace(int sum, int numberIndex) {
        if (numberIndex == numbers.length) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                if (i == 0) {
                    trace(sum + numbers[numberIndex], numberIndex + 1);
                } else if (i == 1) {
                    trace(sum - numbers[numberIndex], numberIndex + 1);
                } else if (i == 2) {
                    trace(sum * numbers[numberIndex], numberIndex + 1);
                } else {
                    trace(sum / numbers[numberIndex], numberIndex + 1);
                }
                operator[i]++;
            }
        }
    }
}
