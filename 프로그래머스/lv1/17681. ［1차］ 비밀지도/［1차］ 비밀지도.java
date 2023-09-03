import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] matrix = new int[n][n];

        int length1 = getLength(arr1);
        int length2 = getLength(arr2);

        for (int i = 0; i < arr1.length; i++) {
            String str = Integer.toBinaryString(arr1[i]);

            if (str.length() != length1) {
                str = matchLength(length1, str);
            }

            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '1') {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            String str = Integer.toBinaryString(arr2[i]);

            if (str.length() != length2) {
                str = matchLength(length2, str);
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 1 && str.charAt(j) == '1') {
                    matrix[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
            sb.delete(0, sb.length());
        }

        return answer;
    }

    public static String matchLength(int length, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - str.length(); i++) {
            sb.append("0");
        }
        sb.append(str);

        return sb.toString();
    }

    public static int getLength(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        String maxBinary = Integer.toBinaryString(max);
        return maxBinary.length(); // 최대 값을 이진수로 변환한 것의 길이를 가져옴
    }
}