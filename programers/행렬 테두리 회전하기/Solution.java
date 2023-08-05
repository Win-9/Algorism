import java.util.*;
import java.lang.*;

class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int minimalsIdx=0;
        map = new int[rows][columns];
        init(rows, columns);
        
        for(int k = 0; k < queries.length; k++) {
            int x1 = queries[k][0] - 1;
            int y1 = queries[k][1] - 1;
            int x2 = queries[k][2] - 1;
            int y2 = queries[k][3] - 1;
            int firstNum = map[x1][y2];
            int min = firstNum;
            for(int i = y2-1; i >= y1; i--){
                min = Math.min(min, map[x1][i]);
                map[x1][i + 1] = map[x1][i];
            }

            // 숫자를 위로 이동 (좌측)
            for(int i = x1+1; i <= x2; i++){
                min = Math.min(min, map[i][y1]);
                map[i - 1][y1] = map[i][y1];
            }

            // 숫자를 좌로 이동 (하단)
            for(int i = y1+1; i <= y2; i++){
                min = Math.min(min, map[x2][i]);
                map[x2][i - 1] = map[x2][i];
            }

            // 숫자를 아래로 이동 (우측)
            for(int i = x2-1; i >= x1; i--){
                min = Math.min(min, map[i][y2]);
                map[i + 1][y2] = map[i][y2];
            }

            map[x1 + 1][y2] = firstNum;
            answer[minimalsIdx] = min;
            minimalsIdx++;
        }

        return answer;
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
