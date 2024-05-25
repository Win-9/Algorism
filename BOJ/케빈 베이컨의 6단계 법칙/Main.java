import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        list = new List[N + 1];
        int min = Integer.MAX_VALUE;
        int answer = N + 1;

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                distance = new int[N + 1];
                visited = new boolean[N + 1];
                if (i == j) {
                    continue;
                }
                bfs(i, j);
                sum += distance[j];
            }

            if (sum < min) {
                min = sum;
                answer = i;
            } else if (sum == min && answer > i) {
                answer = i;
            }
        }

        System.out.println(answer);
    }

    static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;
        visited[start] = true;

        while (!queue.isEmpty()) {
            int w = queue.poll();
            if (w == end) {
                return;
            }

            for (Integer num : list[w]) {
                if (!visited[num]) {
                    queue.add(num);
                    visited[num] = true;
                    distance[num] = distance[w] + 1;
                }
            }
        }
    }
}
