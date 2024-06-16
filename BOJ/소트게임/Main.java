import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        String numbers = br.readLine().replace(" ", "");
        boolean[] visited = new boolean[100000000];

        Queue<Info> queue = new LinkedList<>();
        visited[Integer.parseInt(numbers)] = true;
        queue.add(new Info(numbers, 0));

        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            if (check(poll.number)) {
                System.out.println(poll.count);
                return;
            }

            for (int i = 0; i < N; i++) {
                if (i + K - 1 >= N) {
                    break;
                }

                String revserse = revserse(poll.number, i, i + K);
                if (!visited[Integer.parseInt(revserse)]) {
                    visited[Integer.parseInt(revserse)] = true;
                    queue.add(new Info(revserse, poll.count + 1));
                }
            }
        }

        System.out.println(-1);
    }

    static boolean check(String str) {
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (c + 1 != str.charAt(i)) {
                return false;
            }
            c = str.charAt(i);
        }

        return true;
    }

    static String revserse(String str, int left, int right) {
        StringBuilder sb = new StringBuilder(str.substring(left, right));
        return str.substring(0, left) + sb.reverse() + str.substring(right);
    }

    static class Info {
        String number;
        int count;

        public Info(String number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
