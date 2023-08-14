import java.util.*;

public class Solution {
    static int BASE = 1;
    public int solution(int n) {
        int ans = 0;
        int count = 0;
        
        while(true) {
            if (n == 2 || n == 1) {
                break;
            }
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                count++;
            }
        }

        return BASE + count;
    }
}
