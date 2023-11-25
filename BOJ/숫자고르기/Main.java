import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            map.put(i, num);
        }

        List<Integer> maxList = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            List<Integer> list = new ArrayList<>();
            int count = bfs(visited, i, map, list);
            if (2 <= count) {
                maxList.addAll(list);
            }
        }
        maxList = maxList.stream().distinct().collect(Collectors.toList());

        for (int a : map.keySet()) {
            if (a == map.get(a)) {
                maxList.add(a);
            }
        }

        System.out.println(maxList.size());

        Collections.sort(maxList);
        for(int a : maxList) {
            System.out.println(a);
        }


    }

    static int bfs(boolean[] visited, int start, Map<Integer, Integer> map, List<Integer> keyList) {
        int count = 1;
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> valueList = new ArrayList<>();
        keyList.add(start);
        queue.add(start);
        while(!queue.isEmpty()) {
            int n = queue.poll();
            int value = map.get(n);
            valueList.add(value);
            if (!visited[value]) {
                visited[value] = true;
                keyList.add(value);
                count++;
                queue.add(value);
            }
        }
        
        if (!valueList.containsAll(keyList)) {
            count = 0;
        }
        return count;
    }
}
