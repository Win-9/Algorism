import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static String[][] map;
    static boolean[][] visited;
    static int[] x_loc = {1, - 1, 0, 0};
    static int[] y_loc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = str[j];
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("I")) {
                    answer = bfs(i, j);
                    break;
                }
            }
        }

        if (answer != 0) {
            System.out.println(answer);
        } else {
            System.out.println("TT");
        }
    }

    static int bfs(int startX, int startY) {
        int count = 0;
        Queue<Locations> queue = new LinkedList<>();
        queue.add(new Locations(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Locations loc = queue.poll();

            if (map[loc.x][loc.y].equals("P")) {
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int x = loc.x + x_loc[i];
                int y = loc.y + y_loc[i];

                if (check(x, y) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Locations(x, y));
                }
            }
        }

        return count;
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && !map[x][y].equals("X");
    }

    static class Locations {
        int x;
        int y;

        public Locations(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
