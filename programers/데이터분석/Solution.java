import java.util.*;
import java.lang.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Info> list = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++) {
            if (ext.equals("code")) {
                if (data[i][0] < val_ext) {
                    list.add(new Info(data[i][0], data[i][1], data[i][2], data[i][3]));
                }
            } else if(ext.equals("date")) {
                if (data[i][1] < val_ext) {
                    list.add(new Info(data[i][0], data[i][1], data[i][2], data[i][3]));  
                }
            } else if(ext.equals("maximum")) {
                if (data[i][2] < val_ext) {
                    list.add(new Info(data[i][0], data[i][1], data[i][2], data[i][3]));
                }
            } else {
                if (data[i][3] < val_ext) {
                    list.add(new Info(data[i][0], data[i][1], data[i][2], data[i][3]));
                }
            }
        }
        
        Collections.sort(list, new Comparator<Info>() {
            public int compare(Info i1, Info i2) {
                if (sort_by.equals("code")) {
                    return i1.code - i2.code;
                } else if(sort_by.equals("date")) {
                    return i1.date - i2.date;
                } else if(sort_by.equals("maximum")) {
                    return i1.maximum - i2.maximum;
                } else {
                    return i1.remain - i2.remain;
                }
            }
        });
        
        int[][] answer = list.stream().map(a -> new int[]{a.code, a.date, a.maximum, a.remain})
            .toArray(a -> new int[a][]);
        
        return answer;
    }
    
    static class Info {
        int code;
        int date;
        int maximum;
        int remain;
        
        public Info(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }
}
