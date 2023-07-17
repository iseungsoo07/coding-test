class Solution {
    public int solution(int[] numbers, int k) {
        int idx = 0;
        
        for(int i = 0; i < k - 1; i++) {
            idx += 2;
            if(idx >= numbers.length) {
                idx = Math.abs(numbers.length - idx);
            }
        }
        
        return numbers[idx];
    }
}