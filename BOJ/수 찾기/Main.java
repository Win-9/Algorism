import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        String[] str = br.readLine().split(" ");
        for(String s : str) {
            set.add(Integer.parseInt(s));
        }
        
        int M = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");
        
        for(String s : str) {
            if (set.contains(Integer.parseInt(s))) {
                System.out.println(1);
                continue;
            }
            System.out.println(0);
        }
        
    }
}
