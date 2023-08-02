import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int w, int h) {
        long a = (long) w;
        long b = (long) h;
        return a * b - (a + b - gcd(a, b));
    }
    
    static long gcd(long w, long h) {
        long min = w < h ? w : h;
        long gcd = 0;
        for(long i = 1; i <= min; i++) {
            if (w % i == 0 && h % i == 0) {
                gcd = i;
            }
        }
        
        return gcd;
    }
}
