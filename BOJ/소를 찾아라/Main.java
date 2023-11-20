import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        boolean flag = false;
        int count = 0;
        int answer = 0;
        
        for(int i = 1; i < str.length; i++) {
            if (str[i].equals("(") && str[i - 1].equals("(")) {
                flag = true;
                count++;
                continue;
            }
            
            if (flag && str[i].equals(")") && str[i - 1].equals(")")) {
                answer += count;
            }
        }
        
        System.out.println(answer);
    }
}
