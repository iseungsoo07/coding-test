import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings, (x, y) -> {
            if (x.end == y.end) {
                return x.start - y.start;
            }

            return x.end - y.end;
        });

        int prev = 0;
        for (int i = 0; i < N; i++) {
            if (prev <= meetings[i].start) {
                count++;
                prev = meetings[i].end;
            }
        }

        System.out.println(count);
    }
}
