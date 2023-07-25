import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i * k <= d; i++) {
            int x = i * k;
            for(int j = i; j * k <= d; j++) {
                int y = j * k;
                double num = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                if (num <= d && x == y) {
                    if (!set.contains(x)) {
                        set.add(x);
                    }
                } else if (num <= d) {
                    answer++;
                }
            }
        }
        
        return answer * 2 + set.size();
    }
}
