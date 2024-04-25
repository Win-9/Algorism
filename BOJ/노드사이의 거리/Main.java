import java.lang.*;
import java.io.*;
import java.util.*;


class Main {
    static final int MAX_INT = 100000000;
    static int N;
    static int M;
    static boolean[] visited;
    static int[][] cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        cost = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(cost[i], MAX_INT);
        }

        for (int i = 0; i < N - 1; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int value = Integer.parseInt(str[2]);
            cost[a][b] = value;
            cost[b][a] = value;
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            visited = new boolean[N + 1];
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            System.out.println(bfs(a, b));
        }
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        int[] distance = new int[N + 1];

        while (!queue.isEmpty()) {
            int w = queue.poll();
            if (w == end) {
                break;
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && cost[w][i] < MAX_INT) {
                    distance[i] = cost[w][i] + distance[w];
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return distance[end];
    }
}
