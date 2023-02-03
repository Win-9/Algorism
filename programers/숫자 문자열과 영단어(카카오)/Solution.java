import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> list = Arrays.asList("zero", "one", "two", "three", "four", 
            "five", "six", "seven", "eight", "nine", "ten");
        
        for(int i = 0; i < list.size(); i++) {
            if (s.contains(list.get(i))) {
                s = s.replaceAll(list.get(i), i + "");
            }
        }
        
        
        return Integer.parseInt(s);
    }
}
