import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int brownH;
        int brownV;
        int yellowH = 0;
        int yellowV = 0;
        int[] answer = new int[2];
        
        while(true) {
            yellowV++;
            if (yellow % yellowV != 0) {
                continue;
            }
            yellowH = (yellow / yellowV);
            brownV = (yellowV + 2);
            brownH = (yellowH + 2);
            
            if ((brownH * 2) + (brownV - 2) * 2 == brown) {
                break;
            }
        }
        answer[0] = brownH;
        answer[1] = brownV;
        return answer;
    }
}
