import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.split(" ");
        Map<String, Integer> map = new HashMap<>();
        int startHour = Integer.parseInt(str[0].split(":")[0]);
        int startMinute = Integer.parseInt(str[0].split(":")[1]);

        int endHour = Integer.parseInt(str[1].split(":")[0]);
        int endMinute = Integer.parseInt(str[1].split(":")[1]);

        int streamEndHour = Integer.parseInt(str[2].split(":")[0]);
        int streamEndMinute = Integer.parseInt(str[2].split(":")[1]);

        while((input = br.readLine()) != null && !input.equals("")) {
            str = input.split(" ");
            int hour = Integer.parseInt(str[0].split(":")[0]);
            int minute = Integer.parseInt(str[0].split(":")[1]);

            if ((hour < startHour) || ((hour == startHour) && (minute == startMinute))) {
                map.put(str[1], 1);
            }

            if (((hour > endHour) || (hour == endHour) && (minute >= endMinute))
                    && ((hour < streamEndHour) || (hour == streamEndHour) && (minute <= streamEndMinute))) {
                if (map.get(str[1]) != null) {
                    map.put(str[1], map.get(str[1]) - 1);
                }
            }
        }
        int answer = 0;

        for(String name : map.keySet()) {
            if (map.get(name) <= 0) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
