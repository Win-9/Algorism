import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    static int answer = 0;
    static int N;
    static int S;    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            track(0, i + 1, arr, visited, 0, 0);
        }

        System.out.println(answer);
    }
    //    5 0
//    -7 -3 -2 5 8
    static void track(int depth, int r, int[] arr, boolean[] visited, int start, int sum) {
        if (depth == r) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        for(int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                track(depth + 1, r, arr, visited, i, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}
