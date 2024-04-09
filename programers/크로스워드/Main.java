import java.lang.*;
import java.io.*;
import java.util.*;

class Main {
    static String[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int R = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);
        map = new String[R][C];
        for(int i = 0; i < R; i++) {
            str = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                map[i][j] = str[j];
            }
        }

        String answer = String.valueOf((char)('z'+1));

        for(int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <= C; j++) {
                if (j == C || map[i][j].equals("#")) {
                    if (answer.compareTo(sb.toString()) > 0 && sb.length() > 1) {
                        answer = sb.toString();
                    }
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(map[i][j]);
            }
        }

        for(int i = 0; i < C; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <= R; j++) {
                if (j == R || map[j][i].equals("#")) {
                    if (answer.compareTo(sb.toString()) > 0 && sb.length() > 1) {
                        answer = sb.toString();
                    }
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(map[j][i]);
            }
        }

        System.out.println(answer);
    }
}
