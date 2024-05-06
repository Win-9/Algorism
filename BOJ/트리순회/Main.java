import java.lang.*;
import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] node = new Node[N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            char root = str[0].charAt(0);
            char left = str[1].charAt(0);
            char right = str[2].charAt(0);

            if (node[root - 'A'] == null) {
                node[root - 'A'] = new Node(root);
            }

            if (left != '.') {
                node[left - 'A'] = new Node(left);
                node[root - 'A'].left = node[left - 'A'];
            }

            if (right != '.') {
                node[right - 'A'] = new Node(right);
                node[root - 'A'].right = node[right - 'A'];
            }
        }

        preOrder(node[0]);
        System.out.println();
        inOrder(node[0]);
        System.out.println();
        postOrder(node[0]);
    }

    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }

}
