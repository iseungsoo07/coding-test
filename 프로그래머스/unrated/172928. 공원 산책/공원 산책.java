class Solution {
    public static boolean isPossible(char[][] matrix, int x, int y, char dir, int step) {
        if (dir == 'E') {
            for (int i = 1; i <= step; i++) {
                if (y + i >= matrix[0].length || matrix[x][y + i] == 'X') {
                    return false;
                }
            }
        } else if (dir == 'W') {
            for (int i = 1; i <= step; i++) {
                if (y - i < 0 || matrix[x][y - i] == 'X') {
                    return false;
                }
            }
        } else if (dir == 'S') {
            for (int i = 1; i <= step; i++) {
                if (x + i >= matrix.length || matrix[x + i][y] == 'X') {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= step; i++) {
                if (x - i < 0 || matrix[x - i][y] == 'X') {
                    return false;
                }
            }
        }

        return true;
    }

    public int[] solution(String[] park, String[] routes) {
        char[][] matrix = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                matrix[i][j] = park[i].charAt(j);
            }
        }

        int x = 0; // 시작 지점 x 좌표
        int y = 0; // 시작 지점 y 좌표

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (matrix[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            if (isPossible(matrix, x, y, routes[i].charAt(0), routes[i].charAt(2) - '0')) {
                char dir = routes[i].charAt(0);
                int step = routes[i].charAt(2) - '0';

                if (dir == 'E') {
                    y += step;
                } else if (dir == 'W') {
                    y -= step;
                } else if (dir == 'S') {
                    x += step;
                } else {
                    x -= step;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}