class Solution {
    
    public static int countOne(int num) {
        int count = 0;
        
        String binary = Integer.toBinaryString(num);
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                count++;
            }
        }
        
        return count;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        int n_count = countOne(n);
        int result = n + 1;
        
        while(true) {
            int result_count = countOne(result);
            if(result_count == n_count) {
                break;
            }
            result++;
        }
        
        answer = result;
        
        return answer;
    }
}