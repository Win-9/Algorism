class Main {
    static String[][] map;
    static int R;
    static int C;
    static int[] x_loc = {0, 0, 1, -1};
    static int[] y_loc = {1, -1, 0, 0};
    static Queue<Loc> fireQueue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        map = new String[R][C];
        boolean[][] visited = new boolean[R][C];
        int startX = 0;
        int startY = 0;

        for(int i = 0; i < R; i++) {
            str = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                map[i][j] = str[j];

                if (map[i][j].equals("J")) {
                    startX = i;
                    startY = j;
                }

                if (map[i][j].equals("F")) {
                    fireQueue.add(new Loc(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int count = bfs(startX, startY, visited);
        if (count != 0) {
            System.out.println(count);
        } else {
            System.out.println("IMPOSSIBLE");
        }


    }

    static int bfs(int startX, int startY, boolean[][] visited) {
        Queue<Loc> queue = new LinkedList<>();
        int count = 0;

        visited[startX][startY] = true;
        map[startX][startY] = ".";
        queue.add(new Loc(startX, startY));

        while(!queue.isEmpty()) {
            int fireQueueSize = fireQueue.size();
            int queueSize = queue.size();

            // 불 번짐
            for(int idx = 0; idx < fireQueueSize; idx++) {
                Loc fireLoc = fireQueue.poll();
                for(int i = 0; i < 4; i++) {
                    int fireLocX = fireLoc.x + x_loc[i];
                    int fireLocY = fireLoc.y + y_loc[i];

                    if (check(fireLocX, fireLocY, visited) && map[fireLocX][fireLocY].equals(".")) {
                        visited[fireLocX][fireLocY] = true;
                        map[fireLocX][fireLocY] = "F";
                        fireQueue.add(new Loc(fireLocX, fireLocY));
                    }
                }
            }

            // 사람 이동
            for(int idx = 0; idx < queueSize; idx++) {
                Loc queueLoc = queue.poll();

                if (isEscape(queueLoc.x, queueLoc.y)) {
                    count++;
                    return count;
                }

                for(int i = 0; i < 4; i++) {
                    int locX = queueLoc.x + x_loc[i];
                    int locY = queueLoc.y + y_loc[i];

                    if (check(locX, locY, visited) && map[locX][locY].equals(".")) {
                        visited[locX][locY] = true;
                        queue.add(new Loc(locX, locY));
                    }
                }
            }
            count++;
        }

        return 0;
    }

    static boolean check(int x, int y, boolean[][] visited) {
        return (x >= 0 && x < R) && (y >= 0 && y < C) && !visited[x][y];
    }

    static boolean isEscape(int x, int y) {
        return (x == 0 || x == R - 1) || (y == 0 || y == C - 1);
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
