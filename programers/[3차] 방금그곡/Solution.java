import java.lang.*;
import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int len = 0;
        m = replace(m);
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] musicInfo = musicinfos[i].split(",");
            String startTime = musicInfo[0];
            String endTime = musicInfo[1];
            String title = musicInfo[2];
            String note = replace(musicInfo[3]);
            
            int timeGap = getTime(startTime, endTime);
            String totalNote = getTotalNote(note, timeGap);

            if (totalNote.contains(m)) {
                if (answer.equals("None")) {
                    answer = title;
                    len = timeGap;
                } else if (len < timeGap) {
                    answer = title;
                    len = timeGap;
                }
            }
            
        }
        
        return answer;
    }
    
    static String replace(String str) {
        return str.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("#", "");

    }
    
    static int getTime(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        
        if (start[0].equals(end[0])) {
            return Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
        } else {
            return (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60
                + Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
        }
    }
    
    static String getTotalNote(String note, int length) {
        
        String totalNote = "";
        if (note.length() >= length) {
            totalNote = note.substring(0, length);
        } else {
            int gap = length / note.length();
            for(int i = 0; i < gap; i++) {
                totalNote += note;
            }
            
            totalNote += note.substring(0, length % note.length() + 1);
        }
            
        return totalNote;
    }
}
