class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        int x_max = board[0] / 2;
        int y_max = board[1] / 2;
        int x_start = 0;
        int y_start = 0;
        
        for (int i = 0 ; i < keyinput.length; i++) {
            if (keyinput[i].equals("left")) {
                if(x_start == -x_max) {
                    continue;
                }
                x_start -= 1;
            } else if (keyinput[i].equals("right")) {
                if(x_start == x_max) {
                    continue;
                }
                x_start += 1;
            } else if (keyinput[i].equals("up")) {
                if(y_start == y_max) {
                    continue;
                }
                y_start += 1;
            } else if (keyinput[i].equals("down")) {
                if(y_start == -y_max) {
                    continue;
                }
                y_start -= 1;
            }
        }
        
        answer[0] = x_start;
        answer[1] = y_start;
        
        return answer;
    }
}