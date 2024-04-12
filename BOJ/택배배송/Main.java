import java.lang.*;
import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static int[] distance;
    static int MAX_INT = 50000001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        List<Node>[] list = new List[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            distance[i] = MAX_INT;
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);

            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }

        dijkstra(1, list);
        System.out.println(distance[N]);
    }

    static void dijkstra(int start, List<Node>[] list) {
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        queue.add(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (visited[currentNode.v]) {
                continue;
            }
            visited[currentNode.v] = true;

            for (Node node : list[currentNode.v]) {
                if (distance[node.v] > node.cost + distance[currentNode.v]) {
                    distance[node.v] = node.cost + distance[currentNode.v];
                    queue.add(new Node(node.v, distance[node.v]));
                }
            }
        }

    }

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
