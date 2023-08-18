import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int count = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int lottosIndex = lottos.length - 1;
        int winNumsIndex = lottos.length - 1;
        
        while((lottosIndex >= 0 && winNumsIndex >= 0) && lottos[lottosIndex] != 0) {
            if (lottos[lottosIndex] > win_nums[winNumsIndex]) {
                lottosIndex--;
            } else if (lottos[lottosIndex] < win_nums[winNumsIndex]) {
                winNumsIndex--;
            } else {
                count++;
                lottosIndex--;
                winNumsIndex--;
            }
        }
        
        int zeroCount = 0;
        for(int i = 0; i <= lottosIndex; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            }
        }
        
        
        return new int[]{setRank(count + zeroCount), setRank(count)};
    }
    
    static int setRank(int score) {
        if (score >= 6) {
            return 1;
        } else if (score == 5) {
            return 2;
        } else  if (score == 4) {
            return 3;
        } else  if (score == 3) {
            return 4;
        } else  if (score == 2) {
            return 5;
        } else {
            return 6;
        }
    }
}
