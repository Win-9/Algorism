import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int n) {
        long[] dp = new long[20001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if (n == 1) {
            return dp[1];
        }
        
        if (n == 2) {
            return dp[2];
        }

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        return dp[n];
    }
}
