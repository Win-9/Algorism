import java.util.*;
import java.lang.*;

class Solution {
    static String[] words = {"aya", "ye", "woo", "ma"};
    static String[] duplicatedWords = {"ayaaya", "yeye", "woowoo", "mama"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0; i < babbling.length; i++) {
            StringBuilder str = new StringBuilder(babbling[i]);
            if(duplicatedCheck(str)) {
                continue;
            }

            if (check(str)) {
                answer++;
            }
            
        }
        return answer;
    }
    
    static boolean check(StringBuilder str) {
        for(int i = 0; i < 4; i++) {
            int index = str.indexOf(words[i]);
            if (index == -1) {
                continue;
            }
            str.replace(index, index + words[i].length(), ".");
            i--;
        }
        
        for(int i = 0; i < str.length(); i++) {
            if (!str.substring(i, i + 1).equals(".")) {
                return false;
            }
        }
        
        return true;
    }
    
    static boolean duplicatedCheck(StringBuilder str) {
        for(int i = 0; i < 4; i++) {
            if ((str.toString()).contains(duplicatedWords[i])) {
                return true;
            }
        }
        
        return false;
    }
}
