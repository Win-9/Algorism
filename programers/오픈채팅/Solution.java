import java.util.*;
import java.lang.*;

class Solution {
    final static String ENTER_STR = "님이 들어왔습니다.";
    final static String LEAVE_STR = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<Act> list = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        int count = 0;
        
        for(String s : record) {
            String[] str = s.split(" ");
            list.add(new Act(str[0], str[1]));
            
            switch (str[0]) {
                case "Enter" :
                    count++;
                    map.put(str[1], str[2]);
                    break;
                    
                case "Change" :
                    map.remove(str[1]);
                    map.put(str[1], str[2]);
                    break;
                    
                default:
                    count++;
            }
        }
        
        String[] answer = new String[count];
        
        for(Act act : list) {
            String nickName = map.get(act.getUid());
            String behavior = act.getBehavior();
            
            if (behavior.equals("Enter")) {
                answerList.add(nickName + ENTER_STR);
            } else if (behavior.equals("Leave")) {
                answerList.add(nickName + LEAVE_STR);
            } else {
                continue;
            }
        }
        
        
        return answerList.toArray(new String[0]);
    }
    
    static class Act {
        private String behavior;
        private String uid;
        
        public Act (String behavior, String uid) {
            this.behavior = behavior;
            this.uid = uid;
        }
        
        public String getBehavior() {
            return this.behavior;
        }
        
        public String getUid() {
            return this.uid;
        }
    }
}
