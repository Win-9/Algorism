import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> map = new HashMap<>();
        Map<String, Id> reportMap = new HashMap<>();
        
        for(String s : report) {
            String[] str = s.split(" ");
            if (reportMap.get(str[0]) == null) {
                Id id = new Id(str[0]);
                id.addReport(str[1]);
                map.put(str[1], map.getOrDefault(str[1], 0) + 1);
                reportMap.put(str[0], id);
            } else {
                Id id = reportMap.get(str[0]);
                if (!id.getList().contains(str[1])) {
                    map.put(str[1], map.getOrDefault(str[1], 0) + 1);
                    id.addReport(str[1]);
                }
            }
            
        }
        
        List<String> upK = new ArrayList<>();
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (value >= k) {
                upK.add(key);
            }
        }
        
        for(int i = 0; i < id_list.length; i++) {
            String s = id_list[i];
            Id id = reportMap.get(s);
            int count = 0;
            for(String name : upK) {
                if (id != null && id.getList().contains(name)) {
                    count++;
                }
            }
            
            answer[i] = count;
            
        }
        
        return answer;
    }
    
    static class Id {
        private String name;
        private List<String> reports = new ArrayList<>();
        
        public Id(String name) {
            this.name = name;
        }
        
        public void addReport(String reportName) {
            reports.add(reportName);
        }
        
        public List<String> getList() {
            return reports;
        }
    }
}
