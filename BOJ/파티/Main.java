import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {

    static int[][] distance;
    static int MAX_INT = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int X = Integer.parseInt(str[2]);
        int answer = 0;
        distance = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                distance[i][j] = MAX_INT;
            }
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int value = Integer.parseInt(str[2]);
            distance[a][b] = value;
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, distance[i][X] + distance[X][i]);
        }

        System.out.println(answer);

    }

}
