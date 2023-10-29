import java.lang.*;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List[] list = new List[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] parents = new int[N + 1];
        
        for(int i = 0; i < N - 1; i++) {
            int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (list[nodes[0]] == null) {
                list[nodes[0]] = new ArrayList<Integer>();
            }
            
            if (list[nodes[1]] == null) {
                list[nodes[1]] = new ArrayList<Integer>();
            }
            
            list[nodes[0]].add(nodes[1]);
            list[nodes[1]].add(nodes[0]);
        }
        
        dfs(1, parents, visited, list);
        
        for(int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }    
        
    }
    
    static void dfs(int start, int[] parents, boolean[] visited, List<Integer>[] list) {
        visited[start] = true;
        
        for(int num : list[start]) {
            if (!visited[num]) {
                dfs(num, parents, visited, list);
                parents[num] = start; 
            }
        }
    }
}
