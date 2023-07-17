import java.util.*;

class Solution {
    public  int solution(String s) {
        String answer = "";
        String num = "";

        String[] numbers = {"zero", "one", "two", "three", "four",
                            "five", "six", "seven", "eight", "nine"};


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                num += s.charAt(i);
                for (int j = 0; j < numbers.length; j++) {
                    if (numbers[j].equals(num)) {
                        answer += j;
                        num = "";
                        break;
                    }
                }
            } else {
                answer += s.charAt(i);
            }
        }


        return Integer.parseInt(answer);
    }
    
}