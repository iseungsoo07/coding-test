class Solution {
    public int solution(int price) {
        int answer = price;
        if(price >= 100_000 && price < 300_000) {
            answer = (int)(price * 0.95);
        } else if(price >= 300_000 && price < 500_000) {
            answer = (int)(price * 0.9);
        } else if (price >= 500_000) {
            answer = (int)(price * 0.8);
        }
        
        return answer;
    }
}