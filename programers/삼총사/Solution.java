class Solution {
    static int answer = 0;
    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        check(number, 0, visited, 0, 0);
        return answer;
    }
    
    static void check(int[] number, int start, boolean[] visited, int len, int count) {
        if (len == 3) {
            if (count == 0) {
                answer++;
            }
            
            return;
        }
        
        for(int i = start; i < number.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                check(number, start + 1, visited, len + 1, count + number[i]);
                visited[i] = false;
            }
        }
    }
    
    static void print(boolean[] visited, int[] number) {
        for(int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                System.out.print(number[i] + " ");
            }
        }
            System.out.println();
    }
}
