import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String s) {
        String[] str = s.split("\\},\\{");
        str[0] = str[0].replaceFirst("\\{\\{", "");
        str[str.length - 1] = str[str.length - 1].replaceFirst("\\}\\}", "");
        List<String> list = new ArrayList<>();
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        list.add(str[0]);
        
        for (int i = 1; i < str.length; i++) {
            String[] strArr = str[i].split(",");
            for (int k = 0; k < strArr.length; k++) {
                int index = list.indexOf(strArr[k]);
                if (index == -1) {
                    list.add(strArr[k]);
                }
            }

        }
        
        return list.stream().mapToInt(Integer::parseInt).toArray();

    }
}
