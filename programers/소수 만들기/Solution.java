import java.util.*;
import java.lang.*;

class Solution {
    static int sum = 0;
    static int answer = 0;
    
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        chooseNum(nums, visited, 0, 0);

        return answer;
    }
    
    static void chooseNum(int[] nums, boolean[] visited, int start, int depth) {
        if (depth == 3) {
            if (check()) {
                answer++;
            }
            
            return;
        }
        
        
        for(int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += nums[i];
                chooseNum(nums, visited, i + 1, depth + 1);
                visited[i] = false;
                sum -= nums[i];
            }
        }
    }
    
    static boolean check() {
        for(int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
