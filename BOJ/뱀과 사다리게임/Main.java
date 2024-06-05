import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static Map<Integer, Integer> letter = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    static boolean[] visited = new boolean[101];
    static int[] distance = new int[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            letter.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            snake.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }

        bfs();
        System.out.println(distance[100]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        distance[1] = 0;
        queue.add(1);

        while (!queue.isEmpty()) {
            int w = queue.poll();
            if (w == 100) {
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int location = w + i;
                if (letter.containsKey(location)) {
                    location = letter.get(location);
                } else if (snake.containsKey(location)) {
                    location = snake.get(location);
                }

                if (check(location) && !visited[location]) {
                    visited[location] = true;
                    distance[location] = distance[w] + 1;
                    queue.add(location);
                }
            }
        }
    }

    static boolean check(int num) {
        return num > 1 && num <= 100;
    }
}
