import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret = 0; // checkSecret 변수가 4가 된 순간 체크 배열을 전부 만족

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 문자열의 크기
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 크기

        int result = 0;

        checkArr = new int[4];
        myArr = new int[4];
        char[] A = new char[S];

        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) { // 0이면 항상 만족
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) {
            add(A, i);
        }

        if (checkSecret == 4) {
            result += 1;
        }

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            int j = i - P;
            add(A, i);
            remove(A, j);
            if (checkSecret == 4) {
                result += 1;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void remove(char[] A, int j) {
        switch (A[j]) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }

    private static void add(char[] A, int i) {
        switch (A[i]) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
}
