import java.util.*;
import java.lang.*;

class Solution {
    static int[] x_loc = {-1, 1, 0, 0};
    static int[] y_loc = {0, 0, -1, 1};

    static String[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    public int solution(String[] board) {
        int answer = -1;
        N = board.length;
        M = board[0].length();
        map = new String[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < board.length; i++) {
            String[] str = board[i].split("");
            for(int j = 0; j < str.length; j++) {
                map[i][j] = str[j];
            }
        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("R")){
                    answer = bfs(i, j);
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static int bfs(int startX, int startY) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(startX, startY, 0));

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            if (map[info.x][info.y].equals("G")) {
                return info.count;
            }

            for(int i = 0; i < 4; i++) {
                int x, y;
                if (i == 0 || i == 1) {
                    x = refeatX(x_loc[i], info.x, info.y);
                    y = info.y;
                } else {
                    x = info.x;
                    y = refeatY(y_loc[i], info.y, info.x);
                }

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Info(x, y, info.count + 1));
                }
            }
        }

        return -1;
    }

    static int refeatX(int num, int start, int y) {
        int mul = 1;
        int mulNum = 0;
        while(true) {
            mulNum = num * mul + start;
            if (mulNum < 0) {
                return 0;
            }

            if (mulNum > N - 1) {
                return N - 1;
            }

            if ((mulNum >= 0 && mulNum < N) && (map[mulNum][y].equals("D"))) {
                break;
            }
            mul++;
        }
        if (num == 1) {
            return mulNum - 1;
        }
        return mulNum + 1;
    }

    static int refeatY(int num, int start, int x) {
        int mul = 1;
        int mulNum = 0;
        while (true) {
            mulNum = num * mul + start;

            if (mulNum < 0) {
                return 0;
            }

            if (mulNum > M - 1) {
                return M - 1;
            }

            if ((mulNum >= 0 && mulNum < M) && (map[x][mulNum].equals("D"))) {
                break;
            }
            mul++;
        }

        if (num == 1) {
            return mulNum - 1;
        }
        return mulNum + 1;
    }

    static class Info {
        int x;
        int y;
        int count;

        public Info(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
