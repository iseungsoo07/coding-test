class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        boolean isParallel = false;

        double incl = 0.0;
        double incl2 = 0.0;
        for (int i = 1; i < 4; i++) {
            incl = (double) (dots[i][1] - dots[0][1]) / (dots[i][0] - dots[0][0]);

            if (i == 1) {
                incl2 = (double) (dots[3][1] - dots[2][1]) / (dots[3][0] - dots[2][0]);
            } else if (i == 2) {
                incl2 = (double) (dots[3][1] - dots[1][1]) / (dots[3][0] - dots[1][0]);
            } else {
                incl2 = (double) (dots[2][1] - dots[1][1]) / (dots[2][0] - dots[1][0]);
            }

            if (incl == incl2) {
                isParallel = true;
                break;
            }
        }

        if (isParallel) {
            answer = 1;
        }

        return answer;
    }
}