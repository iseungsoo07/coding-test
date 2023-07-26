class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        while(chicken >= 10) {
            int newChicken = chicken / 10;
            int rest = chicken % 10;
            chicken = newChicken + rest;
            
            answer += newChicken;
        }
        
        return answer;
       
    }
}