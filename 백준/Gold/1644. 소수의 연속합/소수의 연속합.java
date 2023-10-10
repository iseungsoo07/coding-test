import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] eratosthenesSieve(int n) {
        int[] primes = new int[n + 1];

        Arrays.fill(primes, 1);

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            int num = i * 2;

            while (num <= n) {
                primes[num] = 0;
                num += i;
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        int[] primeArr = eratosthenesSieve(n);
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i < primeArr.length; i++) {
            if (primeArr[i] == 1) {
                list.add(i);
            }
        }


        int[] primeNum = list.stream().mapToInt(Integer::intValue).toArray();

        int left = 0;
        int right = 0;
        int sum = primeNum[left];
        int count = 0;

        while (left <= right) {
            if (sum < n) {
                right++;

                if (right >= primeNum.length) {
                    break;
                }

                sum += primeNum[right];
            } else {
                if (sum == n) {
                    count++;
                }

                sum -= primeNum[left];
                left++;
            }
        }

        System.out.println(count);
    }
}
