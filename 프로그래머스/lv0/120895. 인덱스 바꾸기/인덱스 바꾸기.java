class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        
        char[] arr = my_string.toCharArray();
        char temp = ' ';
        
        for(int i = 0; i < arr.length; i++) {
            
            if(i == num1) {
                temp = arr[i];
            }
            
            if(i == num2) {
                arr[num1] = arr[i];
                arr[num2] = temp;
            }
        }
        
        for(char c : arr) {
            answer += c;
        }
        
        return answer;
    }
}