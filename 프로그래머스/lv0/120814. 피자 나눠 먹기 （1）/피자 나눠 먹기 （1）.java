class Solution {
    public int solution(int n) {
        int result = 0;
        int pizza = 7;
        if(n == 1) {
            result = 1;
        } else if(n % pizza == 0) {
            result = n / pizza;
        } else {
            result = n / pizza + 1;
        }
        
        return result;
    }
}