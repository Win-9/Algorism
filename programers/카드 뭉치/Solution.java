import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int firstIndex = 0;
        int secondIndex = 0;
        
        for(int i = 0; i < goal.length; i++) {
            if (firstIndex < cards1.length && cards1[firstIndex].equals(goal[i])) {
                firstIndex++;
            } else if (secondIndex < cards2.length && cards2[secondIndex].equals(goal[i])) {
                secondIndex++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
