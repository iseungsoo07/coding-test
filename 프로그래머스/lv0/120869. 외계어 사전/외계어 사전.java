class Solution {
     public int solution(String[] spell, String[] dic) {
        int answer = 0;

        boolean hasFlag = false;

        for (int i = 0; i < dic.length; i++) {
            for (int j = 0; j < spell.length; j++) {
                if (dic[i].contains(spell[j])) {
                    hasFlag = true;
                } else {
                    hasFlag = false;
                    break;
                }
            }

            if (hasFlag) {
                answer = 1;
                break;
            } else {
                answer = 2;
            }
        }

        return answer;
    }
}