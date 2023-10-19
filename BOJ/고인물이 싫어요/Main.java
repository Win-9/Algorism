import java.lang.*;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int Q = Integer.parseInt(str[2]);
        
        int[] values = new int[N + 1];
        int[] parents = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        
        str = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            values[i + 1] = Integer.parseInt(str[i]);
        }
        
        for(int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            union(x, y, parents);
        }
        
        for(int i = 0; i < Q; i++) {
            int count = 0;
            int num = Integer.parseInt(br.readLine());
            for(int i = 1; i <= N; i++) {
                if (parents[num] == parents[i]) {
                    if (values[i] == 1) {
                        count++;
                    } else {
                        count--;
                    }
                }
            }
            
            if (count > 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        
        
    }
    
    static void union(int x, int y, int[] parents) {
        x = find(x, parents);
        y = find(y, parents);
        
        if (x <= y) {
            parents[y] = parents[x];
        } else {
            parents[x] = parents[y];  
        }
    }
    
    static void find(int x, int[] parents) {
        if (parents[x] == x) {
            return x;
        }
        
        return parents[x] = find(parents[x], parents);
    }
}
