import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        int count = 0;
        
        for(int i = 0; i < str.length - 1; i++) {
            if (str[i].equals("E") && str[i + 1].equals("W")) {
                count++;
            }
        }
        System.out.println(count);

    }
}
