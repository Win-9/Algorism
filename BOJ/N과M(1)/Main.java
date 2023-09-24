import java.lang.*;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        
        int[] out = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        choose(visited, arr, out, M, 0);

    }

    static void choose(boolean[] visited, int[] arr, int[] out, int r, int depth) {
        if (depth == r) {
            print(out, r);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                choose(visited, arr, out, r, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
