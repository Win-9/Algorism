import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Map<String, Integer>> giveInfoMap = new HashMap<>();
        Map<String, Integer> takeMap = new HashMap<>();
        Map<String, Integer> giveMap = new HashMap<>();

        for(String name : friends) {
            Map<String, Integer> map = new HashMap<>();
            for (String friend : friends) {
                if (name.equals(friend)) {
                    continue;
                }
                map.put(friend, 0);
            }
            giveInfoMap.put(name, map);
            takeMap.put(name, 0);
            giveMap.put(name, 0);
        }

        for(String info : gifts) {
            String[] str = info.split(" ");
            String giveName = str[0];
            String takeName = str[1];
            Map<String, Integer> countMap = giveInfoMap.get(giveName);
            countMap.put(takeName, countMap.getOrDefault(takeName, 0) + 1);
            giveInfoMap.put(giveName, countMap);
            giveMap.put(giveName, giveMap.get(giveName) + 1);
            takeMap.put(takeName, takeMap.get(takeName) + 1);
        }

        for(String key : giveInfoMap.keySet()) {
            int count = 0;
            Map<String, Integer> countMap = giveInfoMap.get(key);

            for(String countKey : countMap.keySet()) {
                Map<String, Integer> compareMap = giveInfoMap.get(countKey);
                int compareNum = compareMap.getOrDefault(key, 0);
                if (compareNum < countMap.get(countKey)) {
                    count++;
                } else if (compareNum == countMap.get(countKey)){
                    int firstCount = giveMap.get(key) - takeMap.get(key);
                    int secondCount = giveMap.get(countKey) - takeMap.get(countKey);
                    if (firstCount > secondCount) {
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}
