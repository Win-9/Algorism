import java.util.*;
import java.lang.*;

class Solution {
    static int[] x_loc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] y_loc = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int count = 0;
    
    public int solution(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    count++;
                    bfs(board, visited, i, j);
                }
            }
        }

        
        return board.length * board.length - count;
    }
    
    static void bfs(int[][] map, boolean[][] visited, int startX, int startY) {
        visited[startX][startY] = true;
        for(int i = 0; i < 8; i++) {
            int x = startX + x_loc[i];
            int y = startY + y_loc[i];
                
            if (check(x, y, map) && !visited[x][y]) {
                visited[x][y] = true;
                count++;
            }
        }
    }
    
    static boolean check(int x, int y, int[][] map) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != 1;  
    }
    
    static class Location {
        private int x;
        private int y;
        
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
