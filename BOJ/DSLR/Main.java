import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int A;
    static int B;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            A = Integer.parseInt(str[0]);
            B = Integer.parseInt(str[1]);
            System.out.println(bfs());
        }
    }

    static String bfs() {
        visited = new boolean[10000];
        Queue<Act> queue = new LinkedList<>();
        queue.add(new Act(A, ""));

        while (!queue.isEmpty()) {
            Act poll = queue.poll();
            if (poll.num == B) {
                return poll.act;
            }

            // D
            int DNum = poll.num * 2 % 10000;
            if (!visited[DNum]) {
                visited[DNum] = true;
                queue.add(new Act(DNum, poll.act + "D"));
            }

            // S
            int SNum;
            if (poll.num == 0) {
                SNum = 9999;
            } else {
                SNum = poll.num - 1;
            }
            if (!visited[SNum]) {
                visited[SNum] = true;
                queue.add(new Act(SNum, poll.act + "S"));
            }

            // L 0001 -> 0010
            int num = poll.num;
            num = (num % 1000) * 10 + num / 1000;
            if (!visited[num]) {
                visited[num] = true;
                queue.add(new Act(num, poll.act + "L"));
            }

            // R 0001 -> 1000
            num = poll.num;
            num = (num % 10) * 1000 + num / 10;
            if (!visited[num]) {
                visited[num] = true;
                queue.add(new Act(num, poll.act + "R"));
            }
        }
        return null;
    }

    static class Act {
        int num;
        String act;

        public Act(int num, String act) {
            this.num = num;
            this.act = act;
        }
    }
}
