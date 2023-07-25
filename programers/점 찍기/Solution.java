import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(long i = 0; i * k <= d; i++) {
            long x = i * k;
            long y = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2)) / k;
            
            answer += y + 1;
        }
        
        return answer;
    }
}
