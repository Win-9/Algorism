import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        int resultSize = photo.length;
        int[] answer = new int[resultSize];

        for(int i = 0; i < name.length; i++) {
            map.put(name[i], i);
        }
        
        for(int i = 0; i < resultSize; i++) {
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                if (map.get(photo[i][j]) == null) {
                    continue;
                }
                sum += yearning[map.get(photo[i][j])];
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}
