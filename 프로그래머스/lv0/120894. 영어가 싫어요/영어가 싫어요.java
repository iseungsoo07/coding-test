class Solution {
    public long solution(String numbers) {
        long answer = 0;
        
        String result = "";
        
        int i = 0;
        while(i < numbers.length()) {
            if(numbers.charAt(i) == 'o') {
                result += 1;
                i += 3;
            } else if(numbers.charAt(i) == 't') {
                if(numbers.charAt(i + 1) == 'w') {
                    result += 2;
                    i += 3;
                } else if (numbers.charAt(i + 1) == 'h') {
                    result += 3;
                    i += 5;
                }
            } else if(numbers.charAt(i) == 'f') {
                if(numbers.charAt(i + 1) == 'o') {
                    result += 4;
                    i += 4;
                } else if (numbers.charAt(i + 1) == 'i') {
                    result += 5;
                    i += 4;
                }
            } else if (numbers.charAt(i) == 's') {
                if(numbers.charAt(i + 1) == 'i') {
                    result += 6;
                    i += 3;
                } else if (numbers.charAt(i + 1) == 'e') {
                    result += 7;
                    i += 5;
                }
            } else if (numbers.charAt(i) == 'e') {
                result += 8;
                i += 5;
            } else if (numbers.charAt(i) == 'n') {
                result += 9;
                i += 4;
            } else if (numbers.charAt(i) == 'z') {
                result += 0;
                i += 4;
            }
        }
        
        answer = Long.parseLong(result);
        return answer;
    }
}