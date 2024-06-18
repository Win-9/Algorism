import java.util.*;
import java.lang.*;

class Solution {
    static int[] distance;
    static List<Node>[] list;
    static boolean[] visited;
    static int MAX_INT = 1000000;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        list = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            list[road[0]].add(new Node(road[1], 1));
            list[road[1]].add(new Node(road[0], 1));
        }
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(distance, MAX_INT);
        
        dikstra(destination);
        
        for(int i = 0; i < sources.length; i++) {
            if (distance[sources[i]] == MAX_INT) {
                answer[i] = -1;
                continue;
            }
            
            answer[i] = distance[sources[i]];
        }
        
        
        return answer;
    }
    
    static void dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        distance[start] = 0;
        queue.add(new Node(start, 0));
        
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            
            if (visited[currentNode.des]) {
                continue;
            }
            
            visited[currentNode.des] = true;
            
            for (Node node : list[currentNode.des]) {
                if (distance[node.des] > node.cost + distance[currentNode.des]) {
                    distance[node.des] = node.cost + distance[currentNode.des];
                    queue.add(new Node(node.des, distance[node.des]));
                }
            }
            
        }
        
    }
    
    static class Node {
        int des;
        int cost;
        
        public Node(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }
    }
}
