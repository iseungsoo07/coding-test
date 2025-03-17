import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] A = br.readLine().split(" ");

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(A[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String[] M = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            if (set.contains(Integer.parseInt(M[i]))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
