class Solution {
    public int solution(int[] common) {
        int answer = 0;
        boolean flag = false; // false일 때 등차수열, true일 때 등비수열로 함
        
        if(common[1] - common[0] != common[2] - common[1]) {
           flag = true;
        }
        
        if(flag) {
            int val = common[1] / common[0];
            answer = common[common.length - 1] * val;
            
        } else {
            int val = common[1] - common[0];
            answer = common[common.length - 1] + val;
        }
        
        return answer;
    }
}