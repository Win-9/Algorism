import java.lang.*;
import java.lang.*;

class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        int minNum = n * m / gcd;
            
        return new int[]{gcd, minNum};
    }
    
    static int getGCD(int n, int m) {
        int max = 0;
        for(int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                max = i;
            }
        }
        
        return max;
    }
}
