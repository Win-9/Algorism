import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) { // target array추출
            int sum = 0;
            for(int j = 0; j < targets[i].length(); j++) { //target한글자 검사
                String targetSub = targets[i].substring(j, j + 1);
                int min = 999;
                int firstIdx = 0;
                int zeroCnt = 0;
                for(int k = 0; k < keymap.length; k++) { //keymap 검사
                    firstIdx = keymap[k].indexOf(targetSub);
                    if (firstIdx == -1) {
                        zeroCnt++;
                        continue;
                    }

                    if (firstIdx < min) {
                        min = firstIdx + 1;
                    }
                }

                if (zeroCnt == keymap.length) {
                    sum = -1;
                    break;
                }
                sum += min;
            }
            answer[i] = sum;
        }
        
        
        return answer;
    }
}
