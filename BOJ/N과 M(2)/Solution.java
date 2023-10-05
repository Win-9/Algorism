import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        trace(arr, 0, visited, 0);

    }// 1 2 3 4

    static void trace(int[] arr, int start, boolean[] visited, int depth) {

        if (depth == M) {
            print(visited, arr);
            return;
        }

        for(int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                trace(arr, i + 1, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void print(boolean[] visited, int[] arr) {
        for(int i = 0; i < N; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }

        System.out.println();
    }
}
