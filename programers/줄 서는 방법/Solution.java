import java.lang.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static int count = 0;
    public int[] solution(int n, long k) {
        int[] answer = {};
        int[] arr = new int[n];
        int[] data = new int[n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            data[i] = i + 1;
        }
        
        arr = trace(arr, n, data, 0, k);
        
        return arr;
    }
    
    static int[] trace(int[] arr, int n, int[] data, int depth, long k)  {
        
        if (depth == n) {
            count++;
            return null;
        }
        
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = data[i];
                trace(arr, n, data, depth + 1, k);
                visited[i] = false;
            }
            
            if (count == k) {
                break;
            }
        }
        
        return arr;
    }
}
