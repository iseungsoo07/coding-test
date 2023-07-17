class Solution {
    public String solution(String s) {
        String answer = "";
        int[] alphabet = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] == 1) {
                answer += (char) (97 + i);
            }
        }
        
        return answer;
    }
}