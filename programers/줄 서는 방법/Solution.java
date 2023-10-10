import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] data = new int[n];
        int[] result = new int[n];
        int index = 0;
        int fact = 1;
        for(int i = 0; i < n; i++) {
            data[i] = i + 1;
            fact *= (i + 1);
        }
        
        k--;
        
        while(n > 0) {
            fact /= n;
            int value = (int) (k / fact);
            result[index++] = data[value];
            k %= fact;
            n--;
        }
        
        return result;
    }
}
