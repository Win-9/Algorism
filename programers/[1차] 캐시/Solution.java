import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(String s : cities) {
            s = s.toUpperCase();
            int index = list.indexOf(s);
            if (index == -1) {
                if (list.size() == cacheSize) {
                    list.remove(cacheSize - 1);
                }
                list.add(0, s);
                answer += 5;
            } else {
                list.remove(index);
                list.add(0, s);
                answer += 1;
            }
        }
        
        return answer;
    }
}
