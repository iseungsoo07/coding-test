class Solution {
    public int solution(int[] box, int n) {
        int a = 0;
        int b = 0;
        int c = 0;
        
        for(int i = 0; i < box.length; i++) {
            if(i == 0) {
                a = box[i] / n;
            } else if (i == 1) {
                b = box[i] / n;
            } else {
                c = box[i] / n;
            }
        }
        
        return a * b * c;
    }
}