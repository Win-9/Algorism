import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] x_loc = {1, -1, 0, 0};
    static int[] y_loc = {0, 0, 1, -1};
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);
        String[][] map = new String[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < K; i++) {
            str = br.readLine().split(" ");
            map[Integer.parseInt(str[0]) - 1][Integer.parseInt(str[1]) - 1] = "#";
        }

        int answer = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (map[i][j] != null && !visited[i][j]) {
                    int count = bfs(i, j, visited, map);
                    answer = Math.max(answer, count);
                }
            }
        }

        System.out.println(answer);


    }

    static int bfs(int a, int b, boolean[][] visited, String[][] map) {
        int count = 0;
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(a, b));
        visited[a][b] = true;

        while(!queue.isEmpty()) {
            Loc loc = queue.poll();
            count++;
            for(int i = 0; i < 4; i++) {
                int x = loc.x + x_loc[i];
                int y = loc.y + y_loc[i];
                if (check(x, y, visited) && map[x][y] != null) {
                    visited[x][y] = true;
                    queue.add(new Loc(x, y));
                }
            }
        }

        return count;
    }

    static boolean check(int x, int y, boolean[][] visited) {
        return (x >= 0 && x < N) && (y >= 0 && y < M) && !visited[x][y];
    }

    static class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
