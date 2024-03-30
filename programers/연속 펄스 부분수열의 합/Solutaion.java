import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int[] sequence) {
        int N = sequence.length;
        long[][] dp = new long[N][2];
        
        dp[0][0] = sequence[0];
        dp[0][1] = sequence[0] * -1;
        
        long max = Math.max(dp[0][0], dp[0][1]);
            
        for(int i = 1; i < N; i++) {
            dp[i][0] = Math.max(sequence[i], dp[i - 1][1] + sequence[i]);
            dp[i][1] = Math.max(sequence[i] * -1, dp[i - 1][0] - sequence[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        
        return max;
    }
}
