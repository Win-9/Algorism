class Solution {
    static int answer = 0;
    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        check(number,  visited, 0, number.length, 3, 0);

        return answer;
    }

    static void check(int[] arr, boolean[] visited, int start, int n, int r, int count) {
        if (r == 0) {
            if (count == 0) {
                answer++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            check(arr, visited, i + 1, n, r - 1, count + arr[i]);
            visited[i] = false;
        }
    }

    static void print(boolean[] visited, int[] number) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                System.out.print(number[i] + " ");
            }
        }
        System.out.println();
    }
}
