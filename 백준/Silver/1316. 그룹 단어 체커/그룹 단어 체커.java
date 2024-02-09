import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = 0;
        ArrayList<Character> arrList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            count++;
            for (int j = 0; j < str.length() - 1; j++) {
                if (str.charAt(j) != str.charAt(j + 1)) {
                    if (arrList.contains(str.charAt(j)) || arrList.contains(str.charAt(j + 1))) {
                        count--;
                        break;
                    }
                    arrList.add(str.charAt(j));
                }
            }
            arrList.clear();
        }

        br.close();
        System.out.println(count);
    }
}