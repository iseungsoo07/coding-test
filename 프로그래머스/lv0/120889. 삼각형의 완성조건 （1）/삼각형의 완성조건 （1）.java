class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int max = sides[0];
        int idx = 0;
        
        for(int i = 1; i < sides.length; i++) {
            if(max < sides[i]) {
                max = sides[i];
                idx = i;
            }
        }
        
        switch(idx) {
            case 0:
                if(max < sides[1] + sides[2]) {
                    answer = 1;
                } else {
                    answer = 2;
                }
                break;
            case 1:
                if(max < sides[0] + sides[2]) {
                    answer = 1;
                } else {
                    answer = 2;
                }
                break;
            case 2:
                if(max < sides[1] + sides[0]) {
                    answer = 1;
                } else {
                    answer = 2;
                }
                break;
        }
        
        
        return answer;
    }
}