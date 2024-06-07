import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static String[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        visited = new boolean[N][M];
        distance = new int[N][M];
        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = str[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("2")) {
                    bfs(i, j);
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false && map[i][j].equals("1")) {
                    distance[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void bfs(int startX, int startY) {
        int[] x_loc = {1, -1, 0, 0};
        int[] y_loc = {0, 0, 1, -1};
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Location l = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = l.x + x_loc[i];
                int y = l.y + y_loc[i];

                if (check(x, y) && !visited[x][y]) {
                    visited[x][y] = true;
                    if (map[x][y].equals("1")) {
                        visited[x][y] = true;
                        distance[x][y] = distance[l.x][l.y] + 1;
                        queue.add(new Location(x, y));
                    } else if (map[x][y].equals("0")) {
                        visited[x][y] = true;
                        distance[x][y] = 0;
                    }
                }
            }
        }
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
