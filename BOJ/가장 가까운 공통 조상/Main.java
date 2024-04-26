import java.lang.*;
import java.io.*;
import java.util.*;


class Main {
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int T = Integer.parseInt(str[0]);

        for (int i = 0; i < T; i++) {
            str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            visited = new boolean[N + 1];
            parent = new int[N + 1];
            for (int j = 0; j < N - 1; j++) {
                str = br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                parent[b] = a;
            }
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            System.out.println(find(a, b));
        }
    }

    static int find(int a, int b) {
        while (parent[a] != 0) {
            visited[a] = true;
            a = parent[a];
        }

        while (parent[b] != 0) {
            if (visited[b]) {
                return b;
            }
            visited[b] = true;
            b = parent[b];
        }

        return a;
    }

}
