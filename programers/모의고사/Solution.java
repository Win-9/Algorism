import java.lang.*;
import java.util.*;

class Solution {
    static int[] firstPeople ={1, 2, 3, 4, 5};
    static int[] secondPeople ={2, 1, 2, 3, 2, 4, 2, 5};
    static int[] thirdPeople ={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if (firstPeople[i % firstPeople.length] == answers[i]) {
                score[0]++;
            } 
            
            if (secondPeople[i % secondPeople.length] == answers[i]) {
                score[1]++;
            }
            
            if (thirdPeople[i % thirdPeople.length] == answers[i]) {
                score[2]++;
            }
        }
        
        list.add(1);
        
        for(int i = 1; i < 3; i++) {
            if (score[i] > score[list.get(0) - 1]) {
                if (list.size() == 2) {
                    list.clear();
                } else {
                    list.remove(0);
                }
                list.add(i + 1);
            } else if (score[i] == score[list.get(0) - 1]) {
                list.add(i + 1);
            }
        }
        
        
        
        return list.stream().mapToInt(a -> a).toArray();
    }
}
