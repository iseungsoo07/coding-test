class Solution {
    public int solution(String str1, String str2) {
        
        int str2_len = str2.length();
        
        for(int i = 0 ; i <= str1.length() - str2_len; i++) {
            String str = str1.substring(i, i + str2_len);
            if(str.equals(str2)) {
                return 1;
            }
        }
        
        return 2;
    }
}