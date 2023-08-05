import java.util.*;
import java.lang.*;

class Solution {
    static int subNum;
    static int[][] map;
    static int min = 100000;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int j = 0;
        map = new int[rows][columns];
        init(rows, columns);
        
        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            slideTop(rows, columns, x1, y1, x2, y2);
            slideRight(rows, columns, x1, y1, x2, y2);
            slideBottom(rows, columns, x1, y1, x2, y2);
            slideLeft(rows, columns, x1, y1, x2, y2);
            answer[j++] = subNum;
            subNum = 100000;
        }
        
        return answer;
    }
    
    static void slideTop(int rows, int col, int x1, int y1, int x2, int y2) {
        subNum = map[x1][y2];
        for(int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i - 1];
            if (map[x1][i] < min) {
                min = map[x1][i];
            }
        }

        if (subNum < min) {
            min = subNum;
        }
    }

    static void slideRight(int rows, int col, int x1, int y1, int x2, int y2) {
        int sub = map[x2][y2];
        for(int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            if (map[i][y2] < min) {
                min = map[x1][i];
            }
        }

        map[x1 + 1][y2] = subNum;
        subNum = sub;
        if (subNum < min) {
            min = subNum;
        }
    }

    static void slideBottom(int rows, int col, int x1, int y1, int x2, int y2) {
        int sub = map[x2][y1];
        for(int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i +  1];
            if (map[x2][i] < min) {
                min = map[x1][i];
            }
        }

        map[x2][y2 - 1] = subNum;
        subNum = sub;
        if (subNum < min) {
            min = subNum;
        }
    }

    static void slideLeft(int rows, int col, int x1, int y1, int x2, int y2) {
        for(int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            if (map[i][y1] < min) {
                min = map[x1][i];
            }
        }

        map[x2 - 1][y1] = subNum;
        if (subNum < min) {
            min = subNum;
        }
    }

    static void init(int rows, int columns) {
        int count = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                map[i][j] = count;
                count++;
            }
        }
    }

    static void print(int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.printf("%3d", map[i][j]);
            }
            System.out.println();
        }
    }
}
