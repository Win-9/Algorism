class Solution {
    public int solution(String s) {
        int answer = 0;
        int xCount = 0;
        int nonXCount = 0;
        String x = "";
        for(int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (xCount == 0 || str.equals(x)) {
                x = str;
                xCount++;
                continue;
            }
            
            nonXCount++;
            
            if (xCount == nonXCount) {
                answer++;
                xCount = 0;
                nonXCount = 0;
            } 
            
        }
        
        if (xCount != nonXCount) {
            answer++;
        }
        
        return answer;
    }
}
