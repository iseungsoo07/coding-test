class Solution {
    public int[] solution(String[] wallpaper) {
        int row = wallpaper.length;
        int col = wallpaper[0].length();

        String[][] matrix = new String[row][col];

        int start_row = 0;
        int end_row = 0;
        int start_col = 0;
        int end_col = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = String.valueOf(wallpaper[i].charAt(j));
            }
        }

        for (int i = 0; i < row; i++) {
            if (wallpaper[i].contains("#")) {
                start_row = i;
                break;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            if (wallpaper[i].contains("#")) {
                end_row = i;
                break;
            }
        }

        boolean checkFlag = false;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[j][i].equals("#")) {
                    start_col = i;
                    checkFlag = true;
                    break;
                }
            }
            if (checkFlag) {
                break;
            }
        }

        checkFlag = false;
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                if (matrix[j][i].equals("#")) {
                    end_col = i;
                    checkFlag = true;
                    break;
                }
            }
            if (checkFlag) {
                break;
            }
        }

        int[] answer = new int[4];
        answer[0] = start_row;
        answer[1] = start_col;
        answer[2] = end_row + 1;
        answer[3] = end_col + 1;

        return answer;
    }
}