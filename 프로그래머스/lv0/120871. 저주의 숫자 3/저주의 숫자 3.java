class Solution {
    public int solution(int n) {
        int[] newNum = new int[101];

        int data = 1;
        for(int i = 1; i < newNum.length; i++) {
            if(data % 3 == 0 || String.valueOf(data).contains("3")) {
                data++;
                i--;
            } else  {
                newNum[i] = data++;
            }
        }

        return newNum[n];
    }
}