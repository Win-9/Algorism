import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] str = br.readLine().split(" ");
        int H = Integer.parseInt(str[0]);
        int W = Integer.parseInt(str[1]);
        
        for(int i = 0; i < H; i++) {
            str = br.readLine().split("");
            boolean flag = false;
            int count = -1;
            for(int j = 0; j < str.length; j++) {
                if (str[j].equals("c")) {
                    count = 0;
                    flag = true;
                } else {
                    if (flag) {
                        ++count;
                    }
                }
                bw.write(count + " ");
            }
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
}
