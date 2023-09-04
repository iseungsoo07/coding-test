class Solution {
    
    final static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    
    public String solution(int a, int b) {
        int idx = 5;
        int month = 1;

        if (a == 1) {
            if (b == 1) {
                return day[idx];
            }
            
            for (int i = 2; i <= b; i++) {
                idx = (idx + 1) % day.length;
            }

            return day[idx];
        }

        while (month != a) {
            if (month == 2) {
                idx = (idx + 1) % day.length;
            } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                idx = (idx + 3) % day.length;
            } else {
                idx = (idx + 2) % day.length;
            }

            month++;
        }
        
        if (b == 1) {
            return day[idx];
        }

        for (int i = 2; i <= b; i++) {
            idx = (idx + 1) % day.length ;
        }

        return day[idx];

    }
}