import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {

        String data;
        Node left;
        Node right;

        public Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class BinaryTree {

        Node head;

        public BinaryTree() {
            this.head = null;
        }

        public void addNode(String parent, String left, String right) {
            if (head == null) {
                head = new Node(parent, null, null);
                if (".".equals(left)) {
                    head.left = null;
                } else {
                    head.left = new Node(left, null, null);
                }

                if (".".equals(right)) {
                    head.right = null;
                } else {
                    head.right = new Node(right, null, null);
                }
            } else {
                Node node = getNode(parent);
                if (".".equals(left)) {
                    node.left = null;
                } else {
                    node.left = new Node(left, null, null);
                }

                if (".".equals(right)) {
                    node.right = null;
                } else {
                    node.right = new Node(right, null, null);
                }
            }
        }

        public Node getNode(String s) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(head);

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.data.equals(s)) {
                    return cur;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            return null;
        }

        public void preOrder(Node node) {
            if (node == null) {
                return;
            }

            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        public void inOrder(Node node) {
            if (node == null) {
                return;
            }

            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }

        public void postOrder(Node node) {
            if (node == null) {
                return;
            }

            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int nodes = Integer.parseInt(br.readLine());

        BinaryTree bt = new BinaryTree();

        for (int i = 0; i < nodes; i++) {
            st = new StringTokenizer(br.readLine());

            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            bt.addNode(parent, left, right);
        }

        bt.preOrder(bt.head);
        System.out.println();
        bt.inOrder(bt.head);
        System.out.println();
        bt.postOrder(bt.head);
    }
}
