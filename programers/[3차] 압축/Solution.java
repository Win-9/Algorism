import java.lang.*;
import java.util.*;

class Solution {
    static int index = 1;
    static Map<String, Integer> map = new HashMap<>();
    public int[] solution(String msg) {
        init();
        List<Integer> list = new ArrayList<>();
        
        Loop1:
        for(int i = 0; i < msg.length(); i++) {
            int j = i + 1;
            for(; j <= msg.length(); j++) {
                String str = msg.substring(i, j);

                if (map.get(str) == null) {
                    list.add(map.get(msg.substring(i, j - 1)));
                    map.put(str, index++);
                    i = j - 2;
                    break;
                } else if (map.get(str) != null && j == msg.length()) {
                    list.add(map.get(msg.substring(i, j)));
                    break Loop1;
                }

            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static void init() {
        for(int i = 65; i <= 90; i++) {
            map.put(String.valueOf((char)i), index);
            index++;
        }
    }
}
