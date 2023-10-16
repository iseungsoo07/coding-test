class Solution {
    public int solution(int storey) {
        String tmp = String.valueOf(storey);
    	int[] arr = new int[tmp.length()];
        
    	for(int i = 0; i < tmp.length(); i++) {
    		arr[i] = Character.getNumericValue(tmp.charAt(i));
    	}
    	
    	int answer = 0;
    	
    	for(int i = arr.length-1; i >= 0; i--) {
    		if(arr[i] > 5) {
    			answer += 10 - arr[i];
    			
    			if(i == 0){
                    answer++;  
                } 
                
    			else {
                    arr[i - 1]++;
                }
    		}
    		else if(arr[i] == 5 && i > 0 && arr[i - 1] >= 5) {
    			arr[i - 1]++;
    			answer += 5;
    		}
    		else {
    			answer += arr[i];
    		}

    	}
    	
    	return answer;
    }
}