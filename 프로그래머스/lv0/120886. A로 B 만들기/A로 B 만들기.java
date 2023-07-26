class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        int[] before_alphabet = new int[26];
        int[] after_alphabet = new int[26];
        
        for(int i = 0; i < before.length(); i++) {
            before_alphabet[before.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < after.length(); i++) {
            after_alphabet[after.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++) {
            if(before_alphabet[i] != after_alphabet[i]) {
                answer = 0;
                break;
            }
        }
        
        return answer;
    }
}