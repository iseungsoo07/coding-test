import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Node {
        HashMap<Character, Node> next;
        boolean isTerminal;

        public Node() {
            this.next = new HashMap<>();
            this.isTerminal = false;
        }
    }

    static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String str) {
            Node cur = root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                cur.next.putIfAbsent(c, new Node());
                cur = cur.next.get(c);

                if (i == str.length() - 1) {
                    cur.isTerminal = true;
                    return;
                }
            }
        }

        public boolean isConsistent(String str) {
            Node cur = root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (cur.next.containsKey(c)) {
                    cur = cur.next.get(c);
                    if (cur.isTerminal && i != str.length() - 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void solution(Trie trie, String[] strs) {
        boolean check = false;
        for (int i = 0; i < strs.length; i++) {
            if (!trie.isConsistent(strs[i])) {
                sb.append("NO").append("\n");
                check = true;
                break;
            }
        }

        if (!check) {
            sb.append("YES").append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < t; i++) {
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine()); // 전화번호 개수

            String[] strs = new String[n];

            for (int j = 0; j < n; j++) {
                String hp = br.readLine();
                strs[j] = hp;
                trie.insert(hp);
            }

            solution(trie, strs);
        }

        System.out.println(sb);
    }

}
