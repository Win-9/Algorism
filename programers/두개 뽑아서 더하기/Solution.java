import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                list.add(sum);
            }
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(a -> a).distinct().toArray();
    }
}
