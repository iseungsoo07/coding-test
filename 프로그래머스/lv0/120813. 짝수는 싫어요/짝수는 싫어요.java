class Solution {
    public int[] solution(int n) {
        int count = 0;
        
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 1) {
                count++;
            }
        }
        
        int[] result = new int[count];
        int idx = 0;
        
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 1) {
                result[idx++] = i;
            }
        }
        
        return result;
    }
}