import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static long N;
    static long M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Long.parseLong(str[0]);
        M = Long.parseLong(str[1]);
        long sub = M - N;
        if (sub == 0) {
            System.out.println(0);
            return;
        }
        long K = 1;
        long answer = 0;

        while(K * K <= sub) {
            K++;
        }
        K--;
        answer = K * 2 - 1;
        sub -= K * K;

        while (sub > 0) {
            for(long i = K; i > 0; i--) {
                if(i <= sub) {
                    answer++;
                    sub -= i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
