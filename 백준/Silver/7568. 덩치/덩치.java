import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Person implements Comparable<Person> {

        int weight;
        int height;
        int rate;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(Person o) {
            return this.weight - o.weight;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Person[] people = new Person[n];
        Person[] tmp = new Person[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.arraycopy(people, 0, tmp, 0, n);
        Arrays.sort(people);

        for (int i = 0; i < people.length; i++) {
            Person cur = people[i];
            int rate = 1;

            for (int j = i + 1; j < people.length; j++) {
                Person next = people[j];
                if (cur.weight < next.weight && cur.height < next.height) {
                    rate++;
                }
            }

            cur.setRate(rate);
        }

        for (Person person : tmp) {
            System.out.print(person.rate + " ");
        }

    }
}
