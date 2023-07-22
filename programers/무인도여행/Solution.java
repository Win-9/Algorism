import java.util.*;
import java.lang.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int[] xLoc = {1, -1, 0, 0};
    static int[] yLoc = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        
        int temp[] = list.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
        
        return temp.length == 0 ? new int[]{-1} : temp;
    }
    
    static int bfs(int startX, int startY) {
        Queue<Loc> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new Loc(startX, startY));
        int sum = 0;
        
        while(!queue.isEmpty()) {
            Loc loc = queue.poll();
            sum += map[loc.x][loc.y] - '0';
            for (int i = 0; i < 4; i++) {
                int x = loc.x + xLoc[i];
                int y = loc.y + yLoc[i];
                if (check(x, y) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Loc(x, y));
                }
            }
        }
        
        return sum;
    }
    
    static boolean check(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != 'X';
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
