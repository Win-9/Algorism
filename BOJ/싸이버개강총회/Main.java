import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.split(" ");
        Map<String, Integer> map = new HashMap<>();
        String start = str[0];
        String end = str[1];
        String streamEnd = str[2];

        while((input = br.readLine()) != null && !input.equals("")) {
            str = input.split(" ");
            String time = str[0];

            if (time.compareTo(start) <= 0) {
                map.put(str[1], 1);
                continue;
            }

            if (time.compareTo(end) >= 0 && time.compareTo(streamEnd) <= 0) {
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
