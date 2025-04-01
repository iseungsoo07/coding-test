import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            nameMap.putIfAbsent(name, i + 1);
            numMap.putIfAbsent(i + 1, name);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();

            if (Character.isDigit(str.charAt(0))) {
                int num = Integer.parseInt(str);
                sb.append(numMap.get(num)).append("\n");
            } else  {
                sb.append(nameMap.get(str)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
