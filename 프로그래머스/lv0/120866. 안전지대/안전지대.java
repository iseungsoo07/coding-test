class Solution {
    public static void checkExplosion(int x, int y,
                                      int[][] newBoard) {
        int explosionX;
        int explosionY;
        int[] aroundX = {0, -1, -1, -1, 0, 0, 1, 1, 1};
        int[] aroundY = {0, -1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < 9; i++) {
            explosionX = x + aroundX[i];
            explosionY = y + aroundY[i];
            if (explosionX < newBoard.length 
                && explosionY < newBoard.length)
                if (explosionX >= 0 && explosionY >= 0) {
                    newBoard[explosionX][explosionY] = 1;
                }
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        int[][] newBoard = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    checkExplosion(i, j, newBoard);
                }
            }
        }

        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                if (newBoard[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}