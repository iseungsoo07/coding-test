import java.util.*;

class Student {
    int num;
    double avg;
    boolean visited;
    
    public Student(int num, double avg) {
        this.num = num;
        this.avg = avg;
        this.visited = false;
    }
}

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] avg = new double[score.length];
        ArrayList<Student> list = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++) {
            list.add(new Student(i, (double)(score[i][0] + score[i][1]) / 2));
        }
        
        int count = 0;
        int rank = 1;
        while(count != score.length) {
            double max = -1;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).avg > max && !list.get(i).visited) {
                    max = list.get(i).avg;
                }
            }
            
            int cnt = 0;
            boolean checkFlag = false;
            
            
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).avg == max) {
                    answer[list.get(i).num] = rank;
                    list.get(i).visited = true;
                    cnt++;
                }
                
                if(cnt > 1) {
                    checkFlag = true;
                }
            }
            
            
            if(checkFlag) {
                rank += cnt;
                count += cnt;
            } else {
                rank++;
                count++;
            }
            
        }
        
        return answer;
    }
}