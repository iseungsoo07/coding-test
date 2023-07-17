class Solution {
    public int[] solution(int money) {
        int result[] = new int[2];
        int cnt = 0;
        int rest = 0;
        
        while(money - 5500 >= 0) {
            cnt++;
            money = money - 5500;
        }
        rest = money;
        
        result[0] = cnt;
        result[1] = rest;
        
        return result;
    }
}