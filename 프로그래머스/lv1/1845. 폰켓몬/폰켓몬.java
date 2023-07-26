import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int N  = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int item : nums) {
            set.add(item);
        }
        
        if(set.size() >= N) {
            answer = N;
        } else {
            answer = set.size();
        }
        
        return answer;
    }
}