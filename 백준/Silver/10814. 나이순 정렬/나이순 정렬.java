import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Member implements Comparable<Member> {

        int age;
        String name;
        int num;

        public Member(int age, String name, int num) {
            this.age = age;
            this.name = name;
            this.num = num;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.num - o.num;
            }

            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Member[] member = new Member[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            member[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(member);

        for (Member mem : member) {
            System.out.print(mem.age + " " + mem.name);
            System.out.println();
        }
    }
}
