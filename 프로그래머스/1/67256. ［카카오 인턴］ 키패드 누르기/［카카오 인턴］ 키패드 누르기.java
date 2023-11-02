class Position {
    int x;
    int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public static int distance(Position p1, Position p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        Position[] pos = {
            new Position(3, 1),
            new Position(0, 0), new Position(0, 1), new Position(0, 2),
            new Position(1, 0), new Position(1, 1), new Position(1, 2),
            new Position(2, 0), new Position(2, 1), new Position(2, 2)
        };
        
        Position left = new Position(3, 0);
        Position right = new Position(3, 2);
        
        for(int i = 0 ; i < numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                left = pos[numbers[i]];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                right = pos[numbers[i]];
            } else {
                if(distance(pos[numbers[i]], left) 
                   < distance(pos[numbers[i]], right)){
                    sb.append("L");
                    left = pos[numbers[i]];
                } else if(distance(pos[numbers[i]], left) 
                   > distance(pos[numbers[i]], right)) {
                    sb.append("R");
                    right = pos[numbers[i]];
                } else {
                    if("right".equals(hand)) {
                        sb.append("R");
                        right = pos[numbers[i]];
                    } else {
                        sb.append("L");
                        left = pos[numbers[i]];
                    }
                }
            }
        }
        
        
        return sb.toString();
    }
}