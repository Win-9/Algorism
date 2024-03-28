import java.lang.*;
import java.io.*;
import java.util.*;

class Main {
    static int MAX_INT = 100000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (str[j].equals("Y")) {
                    map[i][j] = 1;
                    continue;
                }
                map[i][j] = MAX_INT;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                if (map[i][j] <= 2) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
