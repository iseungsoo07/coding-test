class Solution {
    public String solution(String polynomial) {
        String answer = "";

        String[] arr = polynomial.replace(" ", "").split("\\+");
        int x = 0;
        int constant = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("x")) {
                String s = arr[i].replace("x", "");
                if (s.equals("")) {
                    s = "1";
                }
                x += Integer.parseInt(s);
            } else {
                constant += Integer.parseInt(arr[i]);
            }
        }

        if(x == 0) {
            answer = String.valueOf(constant);
        } else {
            if(x == 1) {
                if(constant != 0) {
                    answer = "x" + " + " + constant;
                } else {
                    answer = "x";
                }
            } else {
                if(constant != 0) {
                    answer = x + "x" + " + " + constant;
                } else {
                    answer = x + "x";
                }
            }
        }
    
    

        return answer;
    }
}