import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        
        for (int k = 0; k < N; k++) {
            boolean flag = true;
            String[] str = br.readLine().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
            List[] list = new ArrayList[V + 1];
            int[] color = new int[V + 1];
            
            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                str = br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                list[a].add(b);
                list[b].add(a);
            }

            for (int i = 1; i <= V; i++) {
                Collections.sort(list[i]);
            }

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i, color, list)) {
                        flag = false;
                        break;
                    }
                }

            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean bfs(int v,int[] color, List[] list) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        color[v] = 1;

        while(!queue.isEmpty()) {
            int w = queue.poll();
            Iterator<Integer> iter = list[w].listIterator();
            while(iter.hasNext()) {
                int num = iter.next();
                if (color[num] == color[w]) {
                    return false;
                }

                if (color[num] == 0) {
                    color[num] = color[w] * -1;
                    queue.add(num);
                }
            }
        }

        return true;
    }
}
