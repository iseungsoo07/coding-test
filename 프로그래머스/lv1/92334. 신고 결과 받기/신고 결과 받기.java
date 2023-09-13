import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        Map<String, List<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        
        for(String id : id_list) {
            reportMap.put(id, new ArrayList<>());
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            if(reportMap.get(str[0]).contains(str[1])) {
                continue;
            }
            reportMap.get(str[0]).add(str[1]);
        }
        
        // System.out.println(reportMap);
        
        for(Map.Entry<String, List<String>> item : reportMap.entrySet()) {
            for(int i = 0; i < item.getValue().size(); i++) {
                if(!countMap.containsKey(item.getValue().get(i))) {
                    countMap.put(item.getValue().get(i), 1);
                } else {
                    countMap.put(item.getValue().get(i), countMap.get(item.getValue().get(i)) + 1);
                }
            }
        }
        
        // System.out.println(countMap);
        List<String> list = new ArrayList<>();
        
        for(Map.Entry<String, Integer> item : countMap.entrySet()) {
            if(item.getValue() >= k) {
                list.add(item.getKey());
            }
        }
        
        // System.out.println(list);
        
        for(int i = 0; i < list.size(); i++) {
            for(Map.Entry<String, List<String>> item : reportMap.entrySet()) {
                if(item.getValue().contains(list.get(i))) {
                    if(!resultMap.containsKey(item.getKey())) {
                        resultMap.put(item.getKey(), 1);    
                    } else {
                        resultMap.put(item.getKey(), resultMap.get(item.getKey()) + 1);
                    }
                }
            }
            
        }
        
        // System.out.println(resultMap);
        
        for(int i = 0; i < result.length; i++) {
            if(resultMap.get(id_list[i]) == null) {
                result[i] = 0;
            } else {
                result[i] = resultMap.get(id_list[i]);    
            }
        }
        
        // System.out.println(Arrays.toString(result));
        
        return result;
    }
}