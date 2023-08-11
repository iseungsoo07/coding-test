class Solution {
    public int solution(int[] numbers) {
        int total = 45; // 0 - 9 까지의 총합
        
        
        for(int i = 0 ; i < numbers.length; i++) {
            total -= numbers[i];
        }
        
        return total;
    }
}