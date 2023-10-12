import java.util.*;
import java.lang.*;
import java.io.*;


class Main{
    final static String ANSWER_NO = "NO";
    final static String ANSWER_YES = "YES";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[2]);
            if (str[0].equals("0")) {
                union(x, y, parent);
            } else {
                if (isSameParent(x, y, parent)) {
                    bw.write(ANSWER_YES + "\n");
                } else {
                    bw.write(ANSWER_NO + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
    
    static boolean isSameParent(int x, int y, int[] parent) {
        x = find(x, parent);
        y = find(y, parent);
        return x == y;
    }

    static void union(int x, int y, int[] parent) {
        // 서로의 root노드를 찾음
        x = find(x, parent);
        y = find(y, parent);

        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

    }

    static int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
}
