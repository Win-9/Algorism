import java.lang.*;
import java.util.*;

class Solution {
    static int n;
    static int m;
    static int[] xLocation = {1, -1, 0, 0};
    static int[] yLocation = {0, 0, 1, -1};
    static int[][] visited;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        visited[0][0] = 1;
        
        bfs(maps);
        if (visited[n - 1][m - 1] == 0) {
            return -1;
        } else {
            return visited[n - 1][m - 1];
        }
    }
    
    public static void bfs(int[][] maps) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(0, 0));

        while(queue.size() != 0) {
            Location loc = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int x = loc.x + xLocation[i];
                int y = loc.y + yLocation[i];
                
                if (isValid(x, y) && maps[x][y] != 0) {
                    queue.add(new Location(x, y));
                    visited[x][y] += (visited[loc.x][loc.y] + 1);
                }
            }
        }
        
    }
    
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && visited[x][y] == 0;
    }
}

class Location {
    int x;
    int y;
    
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
