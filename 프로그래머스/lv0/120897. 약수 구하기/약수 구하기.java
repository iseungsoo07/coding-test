class Solution {
    
    public static int getDivisorCnt(int n) {
        int count = 0;
        for(int i = 1; i <= n / 2; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        
        count++;
        
        return count;
    }
    
    public static int[] getDivisor(int n) {
        int count = getDivisorCnt(n);
        int[] arr = new int[count];
        
        int idx = 0;
        for(int i = 1; i <= n / 2; i++) {
            if(n % i == 0) {
                arr[idx++] = i;  
            }
        }
        arr[idx] = n;
        
        return arr;
    }
    
    public int[] solution(int n) {
        int[] answer = getDivisor(n);
        
        return answer;
    }
}