import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0; i < book_time.length; i++) {
            String startTime = book_time[i][0];
            String endTime = book_time[i][1];
            if(check(map, startTime, endTime)) {
                answer++;
            }
            map.put(startTime, endTime);
        }
        
        return answer;
    }
    
    static boolean check(HashMap<String, String> map, String startTime, String endTime) {
        for(String s : map.keySet()) {
        if ((s.compareTo(startTime) <= 0 && (map.get(s)).compareTo(startTime) >= 0) || (s.compareTo(endTime) <= 0 && (map.get(s)).compareTo(endTime) >= 0)) {

                return true;
            }
        }
        
        return false;
    }
}
