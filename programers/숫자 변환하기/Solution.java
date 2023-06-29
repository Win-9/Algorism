import java.util.*;
import java.lang.*;

class Solution {
    static int MAX = 1000000;
    public int solution(int x, int y, int n) {
        int[] dp = new int[1000001];
        Arrays.fill(dp, MAX);
        dp[x] = 0;
        
        for(int i = x; i <= y; i++) {
            if (i + n <= y) {
                dp[i + n] =  Math.min(dp[i] + 1, dp[i + n]);
            }
            
            if (i * 2 <= y) {
                dp[i * 2] =  Math.min(dp[i] + 1, dp[i * 2]);
            }
            
            if (i * 3 <= y) {
                dp[i * 3] =  Math.min(dp[i] + 1, dp[i * 3]);
            }
             
        }
        
        if (dp[y] == MAX) {
            return -1;
        } else {
            return dp[y];
        }
        
    }
}
