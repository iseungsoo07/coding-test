class Solution {
    public String solution(String my_string) {
        String answer = "";
        int[] alpha = new int[26];
        
        String lowerCase = my_string.toLowerCase();
        for(int i = 0 ; i < lowerCase.length(); i++) {
            alpha[lowerCase.charAt(i) - 'a']++;
        }
        
        for(int i = 0 ; i < alpha.length; i++) {
            if(alpha[i] >= 1) {
                for(int j = 0; j < alpha[i]; j++) {
                    answer += (char)(i + 97);
                }
            }
        }
        
        return answer;
    }
}