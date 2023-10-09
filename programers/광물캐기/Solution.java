import java.lang.*;
import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int total = 0;
    int[] visited;
    
    public int solution(int[] picks, String[] minerals) {
        visited = new int[picks.length];
 
        for (int pick : picks) {
            total += pick;
        }
 
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == visited[i]) {
                continue;
            }
            visited[i]++;
            dfs(1, 0, i, 0, picks, minerals);
            visited[i]--;
        }
 
 
        return answer;
    }
    
    private void dfs(int count, int startIndex, int pickIndex, int sum, int[] picks, String[] minerals) {
        
        if (answer <= sum) {
            return;
        }       
 
        int add = 0;
        
        for(int i = startIndex; i < startIndex + 5 && i < minerals.length; i++) {
            String mineral = minerals[i];
            if (pickIndex == 0) {
                add += 1;
            } else if (pickIndex == 1) {
                if (mineral.equals("diamond")) {
                    add += 5;
                } else {
                    add += 1;
                }
            } else {
               if (mineral.equals("diamond")) {
                    add += 25;
                } else if (mineral.equals("iron")) {
                    add += 5;
                } else {
                    add += 1;
               }
            }
        }
        
        if (count >= total) {
            answer = Math.min(answer, sum + add);
            return;
        }
 
        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0 || picks[i] == visited[i]) {
                continue;
            }
 
            visited[i]++;
            dfs(count + 1, startIndex + 5, i, sum + add, picks, minerals);
            visited[i]--;
        }
    }
}
