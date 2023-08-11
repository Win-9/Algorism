import java.lang.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        double sub = 0;
        double sum = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> firstMap = new HashMap<>();
        Map<String, Integer> secondMap = new HashMap<>();
        
        initMap(firstMap, str1);
        initMap(secondMap, str2);
        
        if (firstMap.size() == 0) {
            firstMap.put("0", 1);
        }
        
        if (secondMap.size() == 0) {
            secondMap.put("0", 1);
        }
        
        for(String str : firstMap.keySet()) {
            if (secondMap.containsKey(str)) {
                if (firstMap.get(str) > secondMap.get(str)) {
                    sum += firstMap.get(str);
                    sub += secondMap.get(str);
                } else {
                    sum += secondMap.get(str);
                    sub += firstMap.get(str);
                }
            } else {
                sum += firstMap.get(str);
            }
        }
        
        for(String str : secondMap.keySet()) {
            if (!firstMap.containsKey(str)) {
                sum += secondMap.get(str);
            }
        }

        
        return (int) (sub / sum * 65536);
    }
    
    static void initMap(Map<String, Integer> map, String str1) {
        for(int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);
            if (check(s.charAt(0), s.charAt(1))) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
    }
    
    static boolean check(char a, char b) {
        return (a >= 65 && a <= 90) && (b >= 65 && b <= 90);
    }
}
