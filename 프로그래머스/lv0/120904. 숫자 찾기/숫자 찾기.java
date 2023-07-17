class Solution {
    public int solution(int num, int k) {
        String num_str = String.valueOf(num);
        int idx = -1;
        
        for(int i = 0; i < num_str.length(); i++) {
            if(Integer.parseInt(num_str.charAt(i) + "") == k) {
                idx = i + 1;
                break;
            }
        }
        
        return idx;
    }
}