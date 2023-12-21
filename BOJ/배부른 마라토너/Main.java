import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for(int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            map.put(str, map.get(str) - 1);
        }
        
        for (String s : map.keySet()) {
            if (map.get(s) != 0) {
                System.out.println(s);
            }
        }
    }
}
