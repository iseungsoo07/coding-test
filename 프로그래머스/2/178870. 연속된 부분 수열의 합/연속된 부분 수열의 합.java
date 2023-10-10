class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, Integer.MAX_VALUE};
        int left = 0;
        int right = 0;
        int res = sequence[0];

        while (left <= right) {
            if (res < k) {
                right++;

                if (right >= sequence.length) {
                    break;
                }

                res += sequence[right];
            } else {
                if (res == k) {
                    if (answer[1] - answer[0] > right - left) {
                        answer[0] = left;
                        answer[1] = right;
                    }
                }

                res -= sequence[left];
                left++;
            }
        }

        return answer;
    }
}