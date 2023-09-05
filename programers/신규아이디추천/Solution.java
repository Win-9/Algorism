import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String new_id) {
        
        // 1단계
        StringBuilder answer = new StringBuilder(new_id.toLowerCase());
        
        // 2단계
        for(int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == '-' || answer.charAt(i) == '_' || answer.charAt(i) == '.'
                    || (answer.charAt(i) >= 97 && answer.charAt(i) <= 122)
                    || (answer.charAt(i) - '0' >= 0 &&  answer.charAt(i) - '0' <= 9)) {
                continue;
            }

            answer.replace(i, i + 1, "");
            i--;
        }

        // 3단계
        for(int i = 0; i < answer.length(); i++) {
            if (i != answer.length() - 1 && answer.charAt(i) == '.' && answer.charAt(i + 1) == '.') {
                answer.replace(i, i + 2, ".");
                i--;
            }
        }

        // 4단계
        if (answer.charAt(0) == '.') {
            answer.replace(0, 1, "");
        }

        if (answer.length() != 0 && answer.charAt(answer.length() - 1) == '.') {
            answer.replace(answer.length() - 1, answer.length(), "");
        }


        // 5단계
        if (answer.length() == 0) {
            answer = new StringBuilder("a");
        }

        // 6단계
        if (answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));

            if (answer.charAt(14) == '.') {
                answer.replace(14, 15, "");
            }
        }

        // 7단계
        if (answer.length() <= 2) {
            while(answer.length() < 3) {
                answer.append(answer.substring(answer.length() - 1, answer.length()));
            }
        }
        
        return answer.toString();
    }
}
