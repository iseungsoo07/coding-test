import java.util.*;

class Solution {
    
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] visited;
    
    public static int bfs(String[][] maze, int row, int col, int destRow, int destCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int[] dir : dirs) {
                int nRow = cur[0] + dir[0];
                int nCol = cur[1] + dir[1];
                
                if(nRow == destRow && nCol == destCol) {
                    return visited[cur[0]][cur[1]] + 1;
                }
                
                if(nRow < 0 || nCol < 0 || nRow >= maze.length || nCol >= maze[0].length) {
                    continue;
                }
                
                if(maze[nRow][nCol].equals("X")) {
                    continue;
                }
                
                if(visited[nRow][nCol] != 0) {
                    continue;
                }
                
                queue.offer(new int[]{nRow, nCol});
                visited[nRow][nCol] = visited[cur[0]][cur[1]] + 1;
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        String[][] maze = new String[maps.length][maps[0].length()];
        visited = new int[maze.length][maze[0].length];
        int startToLever = 0;
        int leverToExit = 0;
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                }
                
                if(maps[i].charAt(j) == 'L') {
                    lever = new int[]{i, j};
                }
                
                if(maps[i].charAt(j) == 'E') {
                    exit = new int[]{i, j};
                }
            }
        }
        
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                maze[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }
        
        startToLever = bfs(maze, start[0], start[1], lever[0], lever[1]);
        
        if(startToLever == -1) {
            return -1;
        }
        
        visited = new int[maze.length][maze[0].length];
        
        leverToExit += bfs(maze, lever[0], lever[1], exit[0], exit[1]);
        
        if(leverToExit == -1) {
            return -1;
        }
        
        return startToLever + leverToExit;
    }
}