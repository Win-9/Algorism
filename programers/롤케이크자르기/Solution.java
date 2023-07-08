import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();

        for(int i = 0; i < topping.length; i++) {
            firstMap.put(topping[i], firstMap.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++) {
            secondMap.put(topping[i], secondMap.getOrDefault(topping[i], 0) + 1);
            firstMap.put(topping[i], firstMap.getOrDefault(topping[i], 0) - 1);
            
            if (firstMap.get(topping[i]) == 0) {
                firstMap.remove(topping[i]);
            }
            
            if (firstMap.size() == secondMap.size()) {
                answer++;
            }
        }
        
        
        return answer;
    }
}
