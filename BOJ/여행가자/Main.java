import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] parents = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        
        // 집합 정리
        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                int local = Integer.parseInt(str[j]);
                if (local == 1) {
                    union(i + 1, j + 1, parents);
                }
            }
        }
        
        String[] trip = br.readLine().split(" ");
        int parent = find(Integer.parseInt(trip[0]), parents);
        for(int i = 1; i < M; i++) {
            if (parent != find(Integer.parseInt(trip[i]), parents)) {
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
        }
        
        bw.write("YES");
        bw.flush();
        bw.close();
    }
        
    static void union(int x, int y, int[] parents) {
        x = find(x, parents);
        y = find(y, parents);
        
        if (x <= y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }
    
    static int find(int x, int[] parents) {
        if (parents[x] == x) {
            return x;
        }
        
        return parents[x] = find(parents[x], parents);
    }
}
