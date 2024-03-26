import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        String king = str[0];
        String stone = str[1];

        int N = Integer.parseInt(str[2]);

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            String kingLog = king;
            king = kingProcess(command, king);
            if (king.equals(stone)) {
                String stoneLog = stoneProcess(command, stone);
                if (stoneLog.equals(stone)) {
                    king = kingLog;
                }
                stone = stoneLog;
            }
        }

        System.out.println(king);
        System.out.println(stone);
    }

    static String kingProcess(String command, String token) {
        String[] commands = command.split("");

        char tokenX = token.charAt(0);
        int tokenY = Integer.parseInt(String.valueOf(token.charAt(1)));

        for (String instruction : commands) {
            if (instruction.equals("R")) {
                tokenX++;
            } else if (instruction.equals("L")) {
                tokenX--;
            } else if (instruction.equals("B")) {
                tokenY--;
            } else if (instruction.equals("T")) {
                tokenY++;
            }
        }

        if (isXValid(tokenX) && isYValid(tokenY)) {
            return String.valueOf(tokenX) + String.valueOf(tokenY);
        }
        return token;
    }

    static String stoneProcess(String command, String token) {
        String[] commands = command.split("");

        char tokenX = token.charAt(0);
        int tokenY = Integer.parseInt(String.valueOf(token.charAt(1)));

        for (String instruction : commands) {
            if (instruction.equals("R")) {
                tokenX++;
            } else if (instruction.equals("L")) {
                tokenX--;
            } else if (instruction.equals("B")) {
                tokenY--;
            } else if (instruction.equals("T")) {
                tokenY++;
            }
        }

        if (isXValid(tokenX) && isYValid(tokenY)) {
            return String.valueOf(tokenX) + String.valueOf(tokenY);
        }
        return token;
    }

    static boolean isXValid(char x) {
        return x >= 'A' && x <= 'H';
    }

    static boolean isYValid(int y) {
        return y >= 1 && y <= 8;
    }
}
