import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[] visited;
    static int MAX_INT = 10000;
    static int N;
    static int M;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int[] ints : map) {
            Arrays.fill(ints, MAX_INT);
        }
        for(int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            map[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            map[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
        }



        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++){
                for(int k = 1; k <= N; k++) {
                    if (j == k || map[j][i] == MAX_INT || map[i][k] == MAX_INT) {
                        continue;
                    }
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                int minValue = bfs(i);
                list.add(minValue);
            }
        }
        Collections.sort(list);

        System.out.println(count);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    static int bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        int min = getMax(v);
        int minValue = v;

        while (!queue.isEmpty()) {
            v = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && map[v][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                    int sum = getMax(i);
                    if (min > sum) {
                        min = sum;
                        minValue = i;
                    }
                }
            }
        }

        return minValue;
    }

    static int getMax(int num) {
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (map[num][i] != MAX_INT && map[num][i] > max && i != num) {
                max = map[num][i];
            }
        }
        return max;
    }
}
