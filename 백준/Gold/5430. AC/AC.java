import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static Deque<Integer> initDeque(String[] str, Deque<Integer> deque, Deque<Integer> reverse_deque) {
        Deque<Integer> deq = new ArrayDeque<>();

        for (String s : str) {
            if (s.equals("")) {
                break;
            }

            deque.addLast(Integer.parseInt(s));
            reverse_deque.addFirst(Integer.parseInt(s));
        }

        return deque; // 맨 처음에는 기본 상태
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().replace("[", "").replace("]", "").split(",");

            Deque<Integer> deque = new ArrayDeque<>(); // 처음 입력 받은 배열을 저장할 데크
            Deque<Integer> reverse_deque = new ArrayDeque<>(); // 처음 입력 받은 배열을 역순으로 저장한 데크
            Deque<Integer> deq = new ArrayDeque<>(); // 연산에 사용할 데크

            deq = initDeque(str, deque, reverse_deque);
            boolean isError = false;

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    // if (deq.isEmpty()) {
                    //     sb.append("[").append("]");
                    //     break;
                    // }

                    if (deq == deque) {
                        deq = reverse_deque;
                    } else {
                        deq = deque;
                    }
                } else if (p.charAt(j) == 'D') {
                    if (deq.isEmpty()) {
                        isError = true;
                        sb.append("error");
                        break;
                    }

                    deq.pollFirst();
                    if (deq == deque) {
                        reverse_deque.pollLast();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (!deq.isEmpty()) {
                sb.append("[");
                for (Integer data : deq) {
                    sb.append(data).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("]");
            } else if (!isError) {
                sb.append("[").append("]");
            }

            if (i != T - 1) {
                sb.append("\n");
            }
            isError = false;
        }

        br.close();
        System.out.print(sb);

    }


}
