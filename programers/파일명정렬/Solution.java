import java.lang.*;
import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            
            @Override
            public int compare(String s1, String s2) {
                String head1 = s1.split("[0-9]")[0];
                s1 = s1.replace(head1, "");
                head1 = head1.toUpperCase();

                String tempNum = "";
                for(char c : s1.toCharArray()) {
                    if(Character.isDigit(c) && tempNum.length() < 5) {
                        tempNum += c;
                    } else {
                        break;
                    }
                }
                int num1 = Integer.parseInt(tempNum);

                // 두번째 오브젝트 head, num 추출
                String head2 = s2.split("[0-9]")[0];
                s2 = s2.replace(head2, "");
                head2 = head2.toUpperCase();

                tempNum = "";
                for(char c : s2.toCharArray()) {
                    if(Character.isDigit(c) && tempNum.length() < 5) {
                        tempNum += c;
                    } else {
                        break;
                    }
                }
                int num2 = Integer.parseInt(tempNum);
                                
                if (head1
                    .compareTo(head2) <= -1) {
                    return -1;
                } else if (head1
                           .compareTo(head2) >= 1) {
                    return 1;
                } else {

                    if (num1 > num2) {
                        return 1;
                    } else if (num1 < num2) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
                
            }
            
        });
        return files;
    }
}
