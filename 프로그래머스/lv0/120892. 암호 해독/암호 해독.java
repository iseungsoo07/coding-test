class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        int mul = code;
        
        for(int i = 0; i < cipher.length(); i++) {
            if(i == mul - 1) {
                answer += cipher.charAt(i);
                mul += code;
            }
        }
        
        return answer;
    }
}