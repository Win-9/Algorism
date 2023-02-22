import java.util.*;
import java.lang.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toList());
        int index = location;
        while(list.size() != 0) {
            if (index == 0 && list.get(0) == Collections.max(list)) {
                answer++;
                return answer;
            }
            
            if (list.get(0) == Collections.max(list)) {
                list.remove(0);
                answer++;
            } else {
                list.add(list.remove(0));
            }
            
            if (index == 0) {
                index= list.size() - 1;
            } else{
                index--;
            }
        }
        
        return answer;
    }
}
