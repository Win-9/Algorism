import java.util.*;
import java.lang.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] str = (n + "").split("");
        Arrays.sort(str, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder(String.join("", str));
        return Long.parseLong(sb.toString());
    }
}
