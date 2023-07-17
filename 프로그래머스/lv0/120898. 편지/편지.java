class Solution {
    public int solution(String message) {
        int answer = 0;
        
        char[] arr = message.toCharArray();
        
        answer = arr.length * 2;
        
        return answer;
    }
}