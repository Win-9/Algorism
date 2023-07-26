import java.lang.*;
import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(String[] want, int[] number, String[] discount) {
        int i = 0;
        int j = 10;
        Map<String, Integer> map = new HashMap<>();
        
        for(int k = 0; k < 10 ; k++) {  // map 초기설정
            map.put(discount[k], map.getOrDefault(discount[k], 0) + 1);
        }
        
        while(true) {

            if (check(want, number, map)) {
                answer++;
            }
            
            //map조정
            map.put(discount[i], map.get(discount[i++]) - 1);
            if (discount.length <= j) {
                break;
            }
            map.put(discount[j], map.getOrDefault(discount[j++], 0) + 1);
        }
        
        return answer;
    }
    
    static boolean check(String[] want, int[] number, Map<String, Integer> map) {
        for(int i = 0; i < want.length; i++) {
            if (map.get(want[i]) == null || map.get(want[i]) != number[i]) {
                return false;
            }
        }
        return true;
    } 
}
