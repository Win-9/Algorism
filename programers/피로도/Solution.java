import java.lang.*;
import java.util.*;

class Solution {
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        search(visited, k, dungeons, 0);
        return max;
    }
    
    static void search(boolean[] visited, int k, int[][] dungeons, int count) {
        for(int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                search(visited, k - dungeons[i][1], dungeons, ++count);
                visited[i] = false;
            }
        }
        
        if (max < count) {
            max = count;
        }
    }
}
