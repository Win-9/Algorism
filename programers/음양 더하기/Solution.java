import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) {
            int num = signs[i] == true ? absolutes[i]: -absolutes[i];
            answer += num;
        }
        
        return answer;
    }
}
