import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int beforeNumFirst = 0;
        int beforeNumSecond = 0;
        
        // 첫 숫자
        beforeNumFirst = Integer.parseInt(dartResult.substring(0, 1));
        int j = 1;
        
        if (j != dartResult.length() - 1 && isNumber(dartResult.substring(1, 2))) {
            beforeNumFirst = Integer.parseInt(dartResult.substring(0, 2));
            j = 2;
        }
        
        for(; j < dartResult.length(); j++) {
            String str = dartResult.substring(j, j + 1);
            if (isNumber(str)) {
                break;
            } else if (isArea(str)) {
                char ch = str.charAt(0);
                if (ch == 'S') {
                    answer += beforeNumFirst;
                } else if (ch == 'D') {
                    beforeNumFirst = (int) Math.pow(beforeNumFirst, 2);
                    answer += beforeNumFirst;
                } else {
                    beforeNumFirst = (int) Math.pow(beforeNumFirst, 3);
                    answer += beforeNumFirst;
                }
                
            } else {
                char ch = str.charAt(0);
                if (ch == '*') {
                    answer -= beforeNumFirst;
                    beforeNumFirst = beforeNumFirst * 2;
                    answer += beforeNumFirst;
                } else {
                    answer -= beforeNumFirst;
                    beforeNumFirst = beforeNumFirst * -1;
                    answer += beforeNumFirst;                
                }
            }
        }
        
        boolean flag = false;
        
        for(int i = j; i < dartResult.length(); i++) {
            String str = dartResult.substring(i, i + 1);
            if (i != dartResult.length() - 1 && isNumber(dartResult.substring(i, i + 2))) {
                str = dartResult.substring(i, i + 2);
                flag = true;
            }
            if (isNumber(str)) {
                beforeNumSecond = Integer.parseInt(str);
            } else if (isArea(str)) {
                char ch = str.charAt(0);
                if (ch == 'S') {
                    answer += beforeNumSecond;
                } else if (ch == 'D') {
                    beforeNumSecond = (int) Math.pow(beforeNumSecond, 2);
                    answer += beforeNumSecond;
                } else {
                    beforeNumSecond = (int) Math.pow(beforeNumSecond, 3);
                    answer += beforeNumSecond;
                }
                
                if (flag) {
                    if (i != dartResult.length() - 1 
                        && isNumber(dartResult.substring(i + 2, i + 3))) {
                            beforeNumFirst = beforeNumSecond;
                    }
                } else {
                   if (i != dartResult.length() - 1 
                        && isNumber(dartResult.substring(i + 1, i + 2))) {
                            beforeNumFirst = beforeNumSecond;
                    } 
                }
                
                
            } else {
                char ch = str.charAt(0);
                if (ch == '*') {
                    answer -= beforeNumFirst;
                    answer += beforeNumFirst * 2;
                    answer -= beforeNumSecond;
                    answer += beforeNumSecond * 2;
                } else {
                    answer -= beforeNumSecond;
                    beforeNumSecond = beforeNumSecond * -1;
                    answer += beforeNumSecond;
                }
                
                beforeNumFirst = beforeNumSecond;
            }
            
            if (flag){
                i++;
                flag = !flag;
            }
            System.out.println("anser:" + answer);
            
        }
        
        
        return answer;
    }
    
    static boolean isNumber(String str) {
        for(int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    static boolean isArea(String str) {
        return str.length() == 1 && 
            (str.charAt(0) == 'S' || str.charAt(0) == 'D' || str.charAt(0) == 'T');
    }
}
