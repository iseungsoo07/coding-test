class Solution {
    static int minVal = Integer.MAX_VALUE;

    public static void dfs(int[] picks, String[] minerals, int pick,
                           int location, int sum) {
        
        int i = 0;
        for (; i < 5; i++) {
            if (location + i >= minerals.length) {
                break;
            }

            if (pick == 0) {
                sum += 1;
            } else if (pick == 1) {
                if ("diamond".equals(minerals[location + i])) {
                    sum += 5;
                } else {
                    sum += 1;
                }
            } else {
                if ("diamond".equals(minerals[location + i])) {
                    sum += 25;
                } else if ("iron".equals(minerals[location + i])) {
                    sum += 5;
                } else {
                    sum += 1;
                }
            }
        }

        location += i;

        if (location >= minerals.length) {
            if (minVal > sum) {
                minVal = sum;
            }
            return;
        }

        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            if (minVal > sum) {
                minVal = sum;
            }
            return;
        }

        if (sum >= minVal) {
            return;
        }

        for (i = 0; i < 3; i++) {
            if (picks[i] != 0) {
                int[] picksClone = picks.clone();
                picksClone[i] = picksClone[i] - 1;

                dfs(picksClone, minerals, i, location, sum);
            }
        }

    }

    public int solution(int[] picks, String[] minerals) {
        for (int i = 0; i < 3; i++) {
            if (picks[i] != 0) {
                int[] picksClone = picks.clone();
                picksClone[i] = picksClone[i] - 1;

                dfs(picksClone, minerals, i, 0, 0);
            }
        }

        return minVal;
    }
}