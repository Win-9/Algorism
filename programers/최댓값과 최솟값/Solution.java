import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        int[] arr = Arrays.stream(str).mapToInt(a -> Integer.parseInt(a)).toArray();
        
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        
        answer += min + " " + max;

        
        return answer;
    }
}
