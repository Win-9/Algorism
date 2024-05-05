import java.lang.*;
import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            list.add(new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
            score[i] = 1;
        }


        for (int i = 0; i < N; i++) {
            Node currentNode = list.get(i);
            for (int j = 0; j < N; j++) {
                Node node = list.get(j);
                if (currentNode.weight < node.weight && currentNode.height < node.height) {
                    score[i]++;
                }
            }
        }

        for (int i : score) {
            System.out.print(i + " ");
        }
    }

    static class Node {
        int height;
        int weight;

        public Node(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
