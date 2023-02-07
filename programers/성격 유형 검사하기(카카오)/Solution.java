import java.util.*;
import java.lang.*;

class Solution {
    static int[] score = {3,2,1,0,1,2,3};
    static String[] elem = {"RT", "CF", "JM", "AN"};
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> surveyMap = new HashMap<>();
        
        for(int i = 0; i < survey.length; i++) {
            String left = survey[i].substring(0,1);
            String right = survey[i].substring(1,2);
            int scoreIndex = choices[i] - 1;
            
            if (scoreIndex < 3) {
                surveyMap.put(left, 
                              surveyMap.getOrDefault(surveyMap.get(left), 0) + score[scoreIndex]);
            } else if (scoreIndex > 3) {
             surveyMap.put(right, 
                              surveyMap.getOrDefault(surveyMap.get(right), 0) + score[scoreIndex]);   
            }
        }
        
        for(String str : elem) {
            getResult(answer, surveyMap, str);
        }
        
        
        return answer.toString();
    }
    
    static public void getResult(StringBuilder answer, Map<String, Integer> surveyMap, String survey) {
        String left = survey.substring(0, 1);
        String right = survey.substring(1, 2);
        
        int leftValue = surveyMap.getOrDefault(left, 0);
        int rightValue = surveyMap.getOrDefault(right, 0);
        
        if (leftValue > rightValue) {
            answer.append(left);
            return;
        } else if(leftValue < rightValue) {
            answer.append(right);
            return;
        }
        
        if (left.compareTo(right) < 0) {
            answer.append(left);
        } else {
            answer.append(right);            
        }
    }
}
