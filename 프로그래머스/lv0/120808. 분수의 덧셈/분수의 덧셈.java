class Solution {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int denom = denom1 * denom2;
        int numer = numer1 * denom2 + numer2 * denom1;
        
        int gcd = gcd(denom, numer);
        
        int[] result = {numer / gcd, denom / gcd};
        
        return result;
    }
}