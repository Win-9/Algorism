import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[] distance;
    static int MAX = Integer.MAX_VALUE;
    static List<Node> list;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int W = Integer.parseInt(str[2]);
            distance = new int[N + 1];
            list = new ArrayList<>();
            flag = false;

            for (int j = 0; j < M; j++) {
                str = br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                int cost = Integer.parseInt(str[2]);
                list.add(new Node(a, b, cost));
                list.add(new Node(b, a, cost));
            }

            for (int j = 0; j < W; j++) {
                str = br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                int cost = -Integer.parseInt(str[2]);
                list.add(new Node(a, b, cost));
            }

            bellmanFord(1, N, M, W);


            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void bellmanFord(int start, int N, int M, int W) {
        distance[start] = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < list.size(); j++) {
                Node node = list.get(j);
                if (distance[node.start] == MAX) {
                    continue;
                }

                if (distance[node.end] > distance[node.start] + node.cost) {
                    distance[node.end] = distance[node.start] + node.cost;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (distance[node.start] == MAX) {
                continue;
            }

            if (distance[node.end] > distance[node.start] + node.cost) {
                flag = true;
                return;
            }
        }

    }

    static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

}
