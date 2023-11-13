import java.util.*;

class Music {
    String genre;
    int played;
    int idx;
    
    public Music(String genre, int played, int idx) {
        this.genre = genre;
        this.played = played;
        this.idx = idx;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlayed = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            totalPlayed.put(genres[i], totalPlayed.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreSorted = new ArrayList<>();
        
        while (totalPlayed.size() != 0) {
            int max = Integer.MIN_VALUE;
            String max_key = "";
            
            for(String key : totalPlayed.keySet()) {
                if(max < totalPlayed.get(key)) {
                    max = totalPlayed.get(key);
                    max_key = key;
                }
            }
            
            genreSorted.add(max_key);
            totalPlayed.remove(max_key);
        }     
        
        List<Music> musicList = new ArrayList<>();
        for(String genre : genreSorted) {
            List<Music> list = new ArrayList<>();
            
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(genre)) {
                    list.add(new Music(genre, plays[i], i));
                }
            }
            
            Collections.sort(list, (m1, m2) -> m2.played - m1.played);
            
            for(int i = 0; i < list.size(); i++) {
                if (i == 2) {
                    break;
                }
                
                musicList.add(list.get(i));
            }
        }
        
        int[] result = new int[musicList.size()];
        
        for(int i = 0; i < musicList.size(); i++) {
            result[i] = musicList.get(i).idx;
        }
        
        return result;
    }
}