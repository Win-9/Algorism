import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Info> countMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            countMap.put(i, new Info(genres[i], plays[i]));
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        for(String genre : keySet) {
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            for(int index : countMap.keySet()) {
                Info info = countMap.get(index);
                if (!info.genre.equals(genre)) {
                    continue;
                }
                
                if (max == Integer.MIN_VALUE) {
                    max = index;
                    continue;
                }
                
                if (secondMax == Integer.MIN_VALUE) {
                    if (plays[max] > info.count) {
                        secondMax = index;
                    } else {
                        secondMax = max;
                        max = index;
                    }
                    continue;
                }
                
                if (plays[max] < info.count) {
                    secondMax = max;
                    max = index;
                } else if (plays[secondMax] < info.count) {
                    secondMax = index;
                }
            }

            
            if (max != Integer.MIN_VALUE) {
                answer.add(max);
            }
            
            if (secondMax != Integer.MIN_VALUE) {
                answer.add(secondMax);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Info {
        String genre;
        int count;
        
        public Info(String genre, int count) {
            this.genre = genre;
            this.count = count;
        }
    }
}
