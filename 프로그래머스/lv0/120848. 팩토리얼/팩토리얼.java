class Solution {
    
    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    public int solution(int n) {
        int answer = 1;
        
        while(true) {
            if(factorial(answer) <= n && factorial(answer + 1) > n) {
                break;
            } 
            answer++;
        }
        
        return answer;
    }
}