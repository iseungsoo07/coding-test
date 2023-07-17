import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        
        Arrays.sort(array);
        
        for(int i = 0; i < array.length - 1; i++) {
            if(n <= array[0]) {
                answer = array[0];
            } else if (n >= array[array.length - 1]) {
                answer = array[array.length - 1];
            } else {
                if(array[i] <= n && n <= array[i + 1]) {
                    int front = n - array[i];
                    int rear = array[i + 1] - n;
                    if(front > rear) {
                        answer = array[i + 1];
                    } else {
                        answer = array[i];
                    }
                }
            }
        }
        
        return answer;
    }
}