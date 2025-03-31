import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String func = st.nextToken();
            int value = 0;

            if (st.hasMoreTokens()) {
                value = Integer.parseInt(st.nextToken());
            }

            switch (func) {
                case "add":
                    set.add(value);
                    break;
                case "remove":
                    set.remove(value);
                    break;
                case "toggle":
                    if (set.contains(value)) {
                        set.remove(value);
                    } else {
                        set.add(value);
                    }
                    break;
                case "all":
                    set = new HashSet<>(list);
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
                case "check":
                    if (set.contains(value)) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}
