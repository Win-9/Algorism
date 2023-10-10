import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> data = new ArrayList<>();
        int[] result = new int[n];
        int index = 0;
        int fact = 1;
        for(int i = 0; i < n; i++) {
            data.add(i + 1);
            fact *= (i + 1);
        }
        
        k--;
        
        while(n > 0) {
            fact /= n;
            int value = (int) (k / fact);
            result[index++] = data.get(value);
            data.remove(value);
            k %= fact;
            n--;
        }
        
        return result;
    }
}
