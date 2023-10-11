import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> cntMap = new HashMap<>();

    static class Node {
        Map<Character, Node> child = new HashMap<>();
    }

    static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public String insert(String str) {
            Node cur = root;
            boolean flag = false;
            int idx = str.length();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (!cur.child.containsKey(c)) {
                    cur.child.put(c, new Node());

                    if (!flag) {
                        idx = i + 1;
                        flag = true;
                    }
                }

                cur = cur.child.get(c);
            }

            if (!cntMap.containsKey(str)) {
                cntMap.put(str, 1);
                return str.substring(0, idx);
            } else {
                cntMap.put(str, cntMap.get(str) + 1);
                return str.substring(0, idx).concat(String.valueOf(cntMap.get(str)));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            sb.append(trie.insert(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}
