public class Main {
    static int[] x_loc = {1, -1, 0, 0, 0, 0};
    static int[] y_loc = {0, 0, 1, -1, 0, 0};
    static int[] floor_loc = {0, 0, 0, 0, 1, -1};
    static int L;
    static int R;
    static int C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] str = br.readLine().split(" ");
            int answer = 0;
            L = Integer.parseInt(str[0]);
            R = Integer.parseInt(str[1]);
            C = Integer.parseInt(str[2]);
            String[][][] map = new String[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    str = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = str[k];
                    }
                }
                br.readLine();
            }

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k].equals("S")) {
                            answer = bfs(i, j, k, visited, map);
                        }
                    }
                }
            }

            if (answer != 0) {
                System.out.println("Escaped in " + (answer + 1) + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }

    static int bfs(int floor, int x, int y, boolean[][][] visited, String[][][] map) {
        int count = 0;
        Queue<Loc> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(new Loc(floor, x, y, 0));
        visited[floor][x][y] = true;

        while(!queue.isEmpty()) {
            Loc loc = queue.poll();
            for(int i = 0; i < 6; i++) {
                int nextFloor = loc.floor + floor_loc[i];
                int nextX = loc.x + x_loc[i];
                int nextY = loc.y + y_loc[i];

                if (check(nextX, nextY, nextFloor, visited)) {
                    if (map[nextFloor][nextX][nextY].equals(".")) {
                        visited[nextFloor][nextX][nextY] = true;
                        queue.add(new Loc(nextFloor, nextX, nextY, loc.count + 1));
                    } else if (map[nextFloor][nextX][nextY].equals("E")) {
                        flag = true;
                        count = loc.count;
                        break;
                    }
                }
            }

            if (flag) {
                break;
            }
        }

        return count;
    }

    static boolean check(int x, int y, int floor, boolean[][][] visited) {
        return (x >= 0 && x < R) && (y >= 0 && y < C) && (floor >= 0 && floor < L) && !visited[floor][x][y];
    }

    static class Loc {
        int floor;
        int x;
        int y;
        int count;

        public Loc(int floor, int x, int y, int count) {
            this.floor = floor;
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
