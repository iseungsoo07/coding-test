import java.util.*;

class Missile implements Comparable<Missile> {
    int start;
    int end;
    
    public Missile(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int compareTo(Missile o) {
        return this.end - o.end;
    }
}

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Missile[] missiles = new Missile[targets.length];
        
        for(int i = 0; i < missiles.length; i++) {
            missiles[i] = new Missile(targets[i][0], targets[i][1]);
        }
        
        Arrays.sort(missiles);
        
        int prev = 0;
        int next = 1;
        while (true) {
            
            if (next >= missiles.length) {
                answer++;
                break;
            }
            
            Missile curMissile = missiles[prev];
            Missile nextMissile = missiles[next];
            
            if (curMissile.end - 0.5 > nextMissile.start 
                && curMissile.end - 0.5 < nextMissile.end) {
                next++;
                continue;
            }
            
            answer++;
            prev = next;
            next = prev + 1;
        }
        
        return answer;
    }
}