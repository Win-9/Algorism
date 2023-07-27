import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new TreeSet<>();
        int num = 0;
        int count = 0;
        
        String pre = words[0];
        set.add(pre);
        
        for(int i = 1; i < words.length; i++) {
            num = (i + 1) % n;
            if (num == 0) {
                num = n;
            }
            count = i / n + 1;
            
            String str = words[i];
            pre = words[i - 1];
            if (set.contains(str) || str.charAt(0) != pre.charAt(pre.length() - 1)) {
                return new int[]{num, count};
            }
            set.add(str);
        }

        return new int[]{0, 0};
    }
}
