import java.lang.*;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int score = Integer.parseInt(str[1]);
        int P = Integer.parseInt(str[2]);

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] scores = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int count = 1;
        int same = 0;
        for(int i = 0; i < N; i++) {
            if (score > scores[i]) {
                break;
            } else if (score == scores[i]) {
                same++;
                continue;
            }
            count++;
        }

        if (count + same > P) {
            System.out.println("-1");
            return;
        }

        System.out.println(count);
    }
}
