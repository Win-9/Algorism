
import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        int maxIndex = times.length - 1;
        Arrays.sort(times);
        
        long left = 0;
        long right = (long) times[maxIndex] * n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for(int i = 0; i <= maxIndex; i++) {
                sum += mid / times[i];
            }
            
            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}
