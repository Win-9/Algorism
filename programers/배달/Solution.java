import java.util.*;
import java.lang.*;

class Solution {
    static int MAX_INT = 5000001;
    static int[] dist;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List[] list = new ArrayList[N + 1];
        dist = new int[N + 1];
        
        for(int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<Node>();
            dist[i] = MAX_INT;
        }
        
        dist[1] = 0;
        
        for(int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        
        Dijkstra(list);
        
        for(int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    static void Dijkstra(List<Node>[] list) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);
        queue.add(new Node(1, 0));
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            
            for(Node node : list[currentNode.index]){
                if (dist[node.index] > node.cost + dist[currentNode.index]) {
                    dist[node.index] = node.cost + dist[currentNode.index];
                    queue.add(new Node(node.index, dist[node.index]));
                }
            }
        }
    }
    
    static class Node {
        int index;
        int cost;
        
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
