import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = new StringBuilder();
        StringBuilder yStr = new StringBuilder(Y);
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < X.length(); i++) {   // 짝 담기
            String str = X.substring(i, i + 1);
            int index = yStr.indexOf(str);
            
            if (index == -1) {
                continue;
            }
            
            yStr.deleteCharAt(index);
            list.add(str);
        }
        
        if (list.size() == 0) {
            return "-1";
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        if (list.get(0).equals("0")) {
                return "0";
        }
        
        for(String s : list) {
            answer.append(s);
        }
        
        return answer.toString();
    }
}
