class Solution {
    public double solution(int[] numbers) {
        int total = 0;
        
        for(int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
    
        return (double) total / numbers.length;
    }
}