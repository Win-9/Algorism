import java.util.*;
import java.lang.*;

class Solution {
    static final int CLEANTIME = 10;
    static final int HOUR = 60;
    static final int MAXTIME = 1450;
    public int solution(String[][] book_time) {
        int answer = 1;
        int[] hours = new int[MAXTIME];
        for(int i = 0; i < book_time.length; i++) {
            String[] startTime = book_time[i][0].split(":");
            String[] endTime = book_time[i][1].split(":");
            
            hours[Integer.parseInt(startTime[0]) * HOUR + Integer.parseInt(startTime[1])] += 1;
            hours[Integer.parseInt(endTime[0]) * HOUR + Integer.parseInt(endTime[1]) + CLEANTIME] -= 1;
        }
        
        //누적합 구하기
        for(int i = 1; i < MAXTIME; i++) {
            hours[i] += hours[i - 1];
            answer = Math.max(answer, hours[i]);
        }
        
        
        return answer;
    }
}
