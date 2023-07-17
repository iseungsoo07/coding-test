class Solution {
    public int solution(int n) {
        int pizza = 6;
        int count = 1;
        
        while(pizza % n != 0) {
            count++;
            pizza += 6;
        }
        
        return count;
        
        
    }
}