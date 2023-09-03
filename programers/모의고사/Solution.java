import java.lang.*;
import java.util.*;

class Solution {
    static int[] firstPeople ={1, 2, 3, 4, 5};
    static int[] secondPeople ={2, 1, 2, 3, 2, 4, 2, 5};
    static int[] thirdPeople ={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int first = 0;
        int second = 0;
        int third = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if (firstPeople[i % firstPeople.length] == answers[i]) {
                first++;
            } 
            
            if (secondPeople[i % secondPeople.length] == answers[i]) {
                second++;
            }
            
            if (thirdPeople[i % thirdPeople.length] == answers[i]) {
                third++;
            }
        }
        
        if (first == second && second == third) {
            list.add(1);
            list.add(2);
            list.add(3);
        } else if (first >= second || first < second) {
            if (first > second) {
                list.add(1);
            } else if (first < second) {
                list.add(2);
            } else {
                list.add(1);
                list.add(2);
            }
        } else if (second >= third || second < third) {
            if (second > third) {
                list.add(2);
            } else if (second < third) {
                list.add(3);
            } else {
                list.add(2);
                list.add(3);
            }
        } else if (first >= third || first < third) {
            if (first > third) {
                list.add(1);
            } else if (first < third) {
                list.add(3);
            } else {
                list.add(1);
                list.add(3);
            }
        }
        
        
        return list.stream().mapToInt(a -> a).toArray();
    }
}
