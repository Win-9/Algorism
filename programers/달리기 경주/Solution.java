import java.util.*;
import java.lang.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> rankMap = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            rankMap.put(i, players[i]);
            nameMap.put(players[i], i);
        }
        
        for(String s : callings) {
            int rank = nameMap.get(s);
            String beforeName = rankMap.get(rank - 1);
            nameMap.put(s, rank - 1);
            nameMap.put(beforeName, rank);
            rankMap.put(rank - 1, s);
            rankMap.put(rank, beforeName);
        }
        
        
        return rankMap.values().stream().toArray(a -> new String[a]);
    }
}
