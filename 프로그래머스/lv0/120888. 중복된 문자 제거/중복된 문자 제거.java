class Solution {
    public String solution(String my_string) {
        String answer = "";
        boolean isDup = false;
        
        for(int i = 0 ; i < my_string.length(); i++) {
            for(int j = 0; j < answer.length(); j++) {
                if(my_string.charAt(i) == answer.charAt(j)) {
                   isDup = true;
                }
            }
            
            if(!isDup) {
                answer += my_string.charAt(i);
            }
            isDup = false;
        }
        
        return answer;
    }
}