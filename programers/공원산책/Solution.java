import java.lang.*;
import java.util.*;

class Solution {
    static String[][] map = null;
    static int x, y;
    public int[] solution(String[] park, String[] routes) {
        map = new String[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].substring(j, j + 1);
                if (map[i][j].equals("S")) {
                    x = i;
                    y = j;
                }
            }
        }
        
        int subX = x, subY = y;

        for(int i = 0; i < routes.length; i++) {
            String[] str = routes[i].split(" ");
            int way = Integer.parseInt(str[1]);

            for(int j = 0; j < way; j++) {
                switch (str[0]) {
                    case "N":
                        subX -= 1;
                        break;
                    case "S":
                        subX += 1;
                        break;
                    case "W":
                        subY -= 1;
                        break;
                    case "E":
                        subY += 1;
                        break;
                }
                if (!check(subX, subY)) {
                    subX = x;
                    subY = y;
                    break;
                }
            }
            x = subX;
            y = subY;
        }
        int[] answer = {x, y};
        return answer;
    }
    
    static boolean check(int x,int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && !map[x][y].equals("X");
    }
}
