import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            String subStr = s.substring(i, i + 1);
            if (map.get(subStr) == null){
                list.add(-1);
            } else { 
                list.add(i - map.get(subStr));
            }
            map.put(subStr, i);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
