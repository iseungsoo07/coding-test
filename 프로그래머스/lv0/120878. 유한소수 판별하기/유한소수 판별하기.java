class Solution {
    
    public int getGCD(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        
        return getGCD(b, a % b);
    }
    
    public int solution(int a, int b) {
        int answer = 0;
        
        int gcd = getGCD(a, b);
        
        if(gcd != 1) {
            a /= gcd;
            b /= gcd;
        }
        
        if(!(b == 2 || b == 5)) {
            while(b % 2 == 0) {
                b /= 2;
            }  
            
            while(b % 5 == 0) {
                b /= 5;
            }
        }
        
        if(b == 2 || b == 5 || b == 1) {
            answer = 1;
        } else {
            answer = 2;
        }
    
        return answer;
    }
}