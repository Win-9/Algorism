import java.lang.*;
import java.util.*;

class Solution {
    static String[][] map;
    static int[] x_loc = {1, -1, 0, 0};
    static int[] y_loc = {0, 0, -1, 1};
    public int solution(String[] maps) {
        int answer = 0;
        map = new String[maps.length][maps[0].length()];
        boolean[][] leverVisited = new boolean[maps.length][maps[0].length()];
        boolean[][] endVisited = new boolean[maps.length][maps[0].length()];

        int xLever = 0;
        int yLever = 0;
        int xE = 0;
        int yE = 0;

        for(int i = 0; i < maps.length; i++) {
            String s = maps[i];
            for(int j = 0; j < s.length(); j++) {
                map[i][j] = s.substring(j, j + 1);
                if (map[i][j].equals("L")) {
                    xLever = i;
                    yLever = j;
                }
                
                if (map[i][j].equals("E")) {
                    xE = i;
                    yE = j;
                }
            }
        }
        
        for(int i = 0; i < map.length; i++) {
            String[] s = map[i];
            for(int j = 0; j < s.length; j++) {
                if (map[i][j].equals("S")) {
                    answer = bfs(i, j, xLever, yLever, leverVisited);
                    System.out.println(answer);
                    break;
                }
            }
        }
        
        if (answer > -1) {
            int tmp = bfs(xLever, yLever, xE, yE, endVisited);
            if (tmp == -1) {
                return tmp;
            } else {
                answer += tmp;
            }
        }
        
        return answer;
    }
    
    static int bfs(int x, int y, int xEnd, int yEnd, boolean[][] visited) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y, 0));
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            Location loc = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int xLoc = loc.x + x_loc[i];
                int yLoc = loc.y + y_loc[i];
                
                if (xLoc == xEnd && yLoc == yEnd) {
                    return loc.count + 1;
                }
                
                if (check(xLoc, yLoc, visited)) {
                    visited[xLoc][yLoc] = true;
                    queue.add(new Location(xLoc, yLoc, loc.count + 1));
                }
            }
        }
        
        return -1;
    }
    
    static boolean check(int x, int y, boolean[][] visited) {
        return (x >= 0 && x < map.length) && (y >= 0 && y < map[0].length) 
            && !map[x][y].equals("X") && !visited[x][y];
    }
    
    static class Location {
        private int x;
        private int y;
        private int count;
        
        public Location(int x,int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
