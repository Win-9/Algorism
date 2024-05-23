import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();//999909
        int index = 0;
        int N = 0;

        while (true) {
            N++;
            String num = String.valueOf(N);
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) == str.charAt(index)) {
                    index++;
                }

                if (index == str.length()) {
                    System.out.println(N);
                    return;
                }
            }
        }
    }
}

