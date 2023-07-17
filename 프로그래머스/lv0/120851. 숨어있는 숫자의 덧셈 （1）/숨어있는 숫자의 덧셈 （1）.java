class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String str = "";
        
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if(!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z')) {
                str += ch;
            }
        }
        
        String[] arr = str.split("");
        
        for(String s : arr) {
            answer += Integer.parseInt(s);
        }
        
        return answer;
    }
}