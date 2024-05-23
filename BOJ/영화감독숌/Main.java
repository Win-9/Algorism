import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    static final String END = "666";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 0;
        int count = 0;
        while (true) {
            num++;
            if (String.valueOf(num).contains(END)) {
                count++;
            }

            if (count == N) {
                System.out.println(num);
                return;
            }
        }
    }
}
