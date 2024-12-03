import java.io.*;
import java.util.*;

public class Main {
    
    public static int solution(int n, int k) {
        List<ArrayList<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                } else {
                    int x = result.get(i - 1).get(j - 1);
                    int y = result.get(i - 1).get(j);
                
                    list.add(x + y);
                }
            }
            
            result.add(list);
        }
        
        return result.get(n - 1).get(k - 1);
        
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String str = br.readLine();
        
        st = new StringTokenizer(str);
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        System.out.println(solution(n, k));
    }
}