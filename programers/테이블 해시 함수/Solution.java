import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        List<Tuple> tupleList = new ArrayList<>();
        for(int i = 0; i < data.length; i++) {
            tupleList.add(new Tuple(data[i]));
        }
        
        Collections.sort(tupleList, new Comparator<Tuple>() {
            public int compare(Tuple a, Tuple b) {
                if (a.list.get(col -1) < b.list.get(col -1)) {
                    return -1;
                } else if (a.list.get(col -1) > b.list.get(col -1)) {
                    return 1;
                } else {
                    if (a.list.get(0) < b.list.get(0)) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        
        for (int i = row_begin; i <= row_end; i++) {
            Tuple tuple = tupleList.get(i - 1);
            List<Integer> list = tuple.getList();
            int sum = 0;
            for(int a : list) {
                sum += a % i;
            }
            
            answer ^= sum;
        }
        
        return answer;
    }
    
    static class Tuple {
        private List<Integer> list = new ArrayList<>();
        
        public Tuple(int[] data) {
            for(int a : data) {
                list.add(a);
            }
        }
        
        public List<Integer> getList() {
            return list;
        }
    }
}
