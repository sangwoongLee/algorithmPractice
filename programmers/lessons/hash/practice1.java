import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> maps = new HashMap<>();

        for(String user: participant){
             maps.put(user, maps.getOrDefault(user, 0)+1);
        }

        for(String user: completion){
            maps.put(user, maps.getOrDefault(user, 0)-1);
        }

        for( String key : maps.keySet() ){
            if(maps.get(key) >= 1) return key;
        }        
        
        return "";
    }
}
