import java.lang.*;
import java.util.*;

class Solution {
    int x1 = 50, x2, y1 = 50, y2;
    public int[] solution(String[] wallpaper) {
        for(int i = 0; i < wallpaper.length; i++) {
            int index = wallpaper[i].indexOf("#");
            if (index == -1) {
                continue;
            }
            
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if (!wallpaper[i].substring(j, j + 1).equals("#")) {
                    continue;
                }
                
                // x1
                if (x1 >= i) {
                    x1 = i;
                }

                // x2
                if (x2 < i) {
                    x2 = i;
                }

                // y1
                if (y1 > j) {
                    y1 = j;
                }

                // y2
                if (y2 <= j) {
                    y2 = j;
                }
            }
        }
        
        int[] answer = {x1, y1, x2 + 1, y2 + 1};
        return answer;
    }
}
