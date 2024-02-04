import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        String[][] maps = new String[N][M];
        int min = 10000;

        for(int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                maps[i][j] = str[j];
            }
        }

        for(int i = 0; i < N - 7; i++) {
            for(int j = 0; j < M - 7; j++) {
                int count = countDifference(maps, i, j);
                min = Math.min(min, count);
            }
        }

        System.out.println(min);
    }

    static int countDifference(String[][]map, int x, int y) {
        int count = 0;
        String color = "W";

        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                if (!map[i][j].equals(color)) {
                    count++;
                }

                if (color.equals("W")){
                    color = "B";
                } else {
                    color = "W";
                }
            }

            if (color.equals("W")){
                color = "B";
            } else {
                color = "W";
            }
        }
        count = Math.min(count, 64 - count);
        return count;
    }
}
