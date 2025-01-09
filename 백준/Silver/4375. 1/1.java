import java.io.*;
import java.util.*;

public class Main {
    public static int One(int num) {
        int x = 1;
        for (int i = 1; ; i++) {
            x = x % num;
            x = x * 10 + 1;
            if (x == 1) {
                return i;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();

        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            sb.append(One(n)).append("\n");
        }

        System.out.println(sb);
    }
}