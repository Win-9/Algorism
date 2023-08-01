import java.lang.*;
import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        Set<Location> set = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++) {
            String s = dirs.substring(i, i + 1);
            int startX = x;
            int startY = y;
            switch(s) {
                case "U":
                    y++;
                    break;
                case "D":
                    y--;
                    break;
                case "L":
                    x--;
                    break;
                case "R":
                    x++;
                    break;
            }
            
            if ((x < -5 || x > 5) || (y < -5 || y > 5)) {
                x = startX;
                y = startY;
                continue;
            }
            set.add(new Location(startX, startY, x, y));
        }
        
        return set.size();
    }
    
    static class Location {
        private int beforeX;
        private int beforeY;
        private int afterX;
        private int afterY;
        
        
        public Location(int beforeX, int beforeY, int afterX, int afterY) {
            this.beforeX = beforeX;
            this.beforeY = beforeY;
            this.afterX = afterX;
            this.afterY = afterY;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(beforeX + afterX, beforeY + afterY);
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Location)) {
                return false;
            }
            
            Location location = (Location) o;
            
            return ((location.beforeX == this.beforeX && location.beforeY == this.beforeY) &&
                (location.afterX == this.afterX && location.afterY == this.afterY)) ||
                ((location.beforeX == this.afterX && location.beforeY == this.afterY) &&
                (location.afterX == this.beforeX && location.afterY == this.beforeY)); 
        }
    } 
}
