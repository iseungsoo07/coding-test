import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Bst {
        Node head;

        public Bst(int data) {
            this.head = new Node(data, null, null);
        }

        public Node addNode(Node cur, int data) {
            if (cur == null) {
                return new Node(data, null, null);
            }

            if (data < cur.data) {
                cur.left = addNode(cur.left, data);
            } else {
                cur.right = addNode(cur.right, data);
            }

            return cur;
        }

        public void postOrder(Node cur) {
            if (cur == null) {
                return;
            }

            postOrder(cur.left);
            postOrder(cur.right);
            System.out.println(cur.data);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> data = new ArrayList<>();

        while (sc.hasNext()) {
            data.add(sc.nextInt());
        }

        Bst bst = new Bst(data.get(0));
        data.remove(0);

        for (int i = 0; i < data.size(); i++) {
            bst.addNode(bst.head, data.get(i));
        }

        bst.postOrder(bst.head);
    }
}
