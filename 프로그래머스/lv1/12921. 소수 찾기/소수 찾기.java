import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n + 1];
        
        for(int i = 2; i <= n; i++) {
            arr[i] = 1;
        }
        
        for(int i = 2; i <= (int) Math.sqrt(n); i++){
            if(arr[i] == 0) {
                continue;
            }
            
            int num = i * 2;
            while(num <= n) {
                arr[num] = 0;
                num += i;
            }
        }
        
        return Arrays.stream(arr).sum();
    }
}