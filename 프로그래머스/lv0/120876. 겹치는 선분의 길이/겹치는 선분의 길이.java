class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[200];

        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0]; j < lines[i][1]; j++) {
                arr[j + 100]++;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                count++;
            }
        }

        return count;
    }
}