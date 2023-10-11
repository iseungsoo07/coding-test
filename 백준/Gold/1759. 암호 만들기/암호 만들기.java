import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String arr[];
    static boolean[] visited;
    static int l, c;

    public static void dfs(int start, int count) {
        if (count == l) {
            String word = "";
            int a = 0;
            int b = 0;
            for (int i = 0; i < c; i++) {
                if (visited[i]) {
                    word += arr[i];

                    if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                        a++;
                    } else {
                        b++;
                    }
                }
            }
            if (a >= 1 && b >= 2) {
                System.out.println(word);
            }
        }

        for (int i = start; i < c; i++) {
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[c];
        visited = new boolean[c];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        dfs(0, 0);


    }
}
