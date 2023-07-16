import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        int idx = 0;
        while (list.size() != 1) {
            int newIdx = idx + K - 1;
            if (newIdx >= list.size()) {
                newIdx = newIdx % list.size();
            }
            int data = list.remove(newIdx);
            sb.append(data + ", ");
            idx = newIdx;
        }

        sb.append(list.get(0)).append(">");


        System.out.println(sb.toString());


    }
}
