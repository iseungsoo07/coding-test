class Solution {
    public int solution(int slice, int n) {
        int count = 1;
        if(n == 1 || slice == n) {
            count = 1;
        } else if(n % slice == 0) {
            count = n / slice;
        } else {
            count =  n / slice + 1;
        }
        
        return count;
    }
}