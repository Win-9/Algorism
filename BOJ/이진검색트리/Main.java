import java.lang.*;
import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tree tree = new Tree();

        String str = null;
        while ((str = br.readLine()) != null) {
            int data = Integer.parseInt(str);
            tree.root(data);
        }

        tree.postOrder(tree.node);

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Tree {
        Node node;

        void root(int data) {
            if (node == null) {
                node = new Node(data);
                return;
            }

            insert(node, data);
        }

        void insert(Node root, int data) {
            if (root.data > data) {
                if (root.left == null) {
                    root.left = new Node(data);
                    return;
                }
                insert(root.left, data);
            }

            if (root.data < data) {
                if (root.right == null) {
                    root.right = new Node(data);
                }
                insert(root.right, data);
            }
        }

        void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }
}
