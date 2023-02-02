import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answerList = new ArrayList<>();
        List<Integer> scoreList = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++) {
            scoreList.add(score[i]);
            Collections.sort(scoreList);
            
            if (scoreList.size() > k){
                scoreList.remove(0);
            }
            
            answerList.add(scoreList.get(0));
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
