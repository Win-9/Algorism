import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static String[][]map;
    static boolean[][]visited;
    static int N;
    static int M;
    static int[] x_loc = {1, -1, 0, 0};
    static int[] y_loc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        visited = new boolean[N][M];
        map = new String[N][M];

        for(int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = str[j];
            }
        }

        int wSum = 0;
        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j].equals("W")) {
                    count += Math.pow(bfs(i, j, "W"), 2);
                }
            }
            wSum += count;
        }

        visited = new boolean[N][M];
        int bSum = 0;
        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j].equals("B")) {
                    count += Math.pow(bfs(i, j, "B"), 2);
                }
            }
            bSum += count;
        }

        System.out.print(wSum + " " + bSum);
    }

    static int bfs(int startX, int startY, String mark) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startX, startY));
        visited[startX][startY] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            Location loc = queue.poll();

            for(int i = 0; i < 4; i++) {
                int x = loc.x + x_loc[i];
                int y = loc.y + y_loc[i];

                if (check(x, y) && !visited[x][y] && map[x][y].equals(mark)) {
                    visited[x][y] = true;
                    count++;
                    queue.add(new Location(x, y));
                }
            }
        }

        return count;
    }

    static boolean check(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
