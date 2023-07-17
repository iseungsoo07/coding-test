class Solution {
    public String solution(int age) {
        String answer = "";
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};

        String str = String.valueOf(age);
        for (int i = 0; i < str.length(); i++) {
            answer += arr[Integer.parseInt((str.charAt(i) + ""))];
        }

        return answer;
    }
}