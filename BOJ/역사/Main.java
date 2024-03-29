import java.lang.*;
import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static int MAX_INT = 10000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        map = new int[N + 1][N + 1];

        for (int[] ints : map) {
            Arrays.fill(ints, MAX_INT);
        }
        for(int i = 0; i < K; i++) {
            str = br.readLine().split(" ");
            map[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++){
                for(int k = 1; k <= N; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        int S = Integer.parseInt(br.readLine());

        for(int i = 0; i < S; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            if (map[a][b] < map[b][a]) {
                System.out.println(-1);
            } else if (map[a][b] > map[b][a]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
