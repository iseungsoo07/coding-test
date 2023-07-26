class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        String[] nums = new String[j - i + 1];
        int idx = 0;
        for(int a = i; a <= j; a++) {
            nums[idx++] = String.valueOf(a);
        }
        
        for (int m = 0; m < nums.length; m++) {
            for (int n = 0; n < nums[m].length(); n++) {
                if(nums[m].charAt(n) - '0' == k) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}