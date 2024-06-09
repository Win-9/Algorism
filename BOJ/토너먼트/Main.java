import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int A = Integer.parseInt(str[1]);
        int B = Integer.parseInt(str[2]);
        int answer = 1;
        while (true) {
            if (A % 2 == 0) {
                A /= 2;
            } else {
                A = (A + 1) / 2;
            }

            if (B % 2 == 0) {
                B /= 2;
            } else {
                B = (B + 1) / 2;
            }

            if (A == B) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }

}
