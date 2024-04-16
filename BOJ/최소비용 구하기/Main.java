import java.lang.*;
import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static int[] distance;
    static int MAX_INT = 100000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        List<Node>[] list = new List[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            distance[i] = MAX_INT;
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            list[a].add(new Node(cost, b));
        }

        str = br.readLine().split(" ");
        int start = Integer.parseInt(str[0]);
        int end = Integer.parseInt(str[1]);

        dijkstra(start, list);

        System.out.println(distance[end]);
    }

    static void dijkstra(int startNode, List<Node>[] list) {
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        queue.add(new Node(0, startNode));
        distance[startNode] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (visited[currentNode.index]) {
                continue;
            }
            visited[currentNode.index] = true;

            for (Node node : list[currentNode.index]) {
                if (distance[node.index] > node.cost + distance[currentNode.index]) {
                    distance[node.index] = node.cost + distance[currentNode.index];
                    queue.add(new Node(distance[node.index], node.index));
                }
            }
        }
    }

    static class Node {
        int cost;
        int index;

        public Node(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }
}
