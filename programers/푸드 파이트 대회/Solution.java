class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i] / 2; j++) {
                answer.append(i);
            }
        }
        String revserseStr = answer.reverse().toString();
        answer.reverse();
        answer.append(revserseStr);
        answer.insert(answer.length() / 2, 0);
        return answer.toString();
    }
}
