import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, List<String>> maps = new HashMap();


        for(int i=0; i <clothes.length; i++){
            List<String> lists = maps.getOrDefault(clothes[i][1], new LinkedList<>());
            lists.add(clothes[i][0]);
            maps.put(clothes[i][1], lists);
        }
        System.out.println(maps.values());

        for(List<String> lists : maps.values()) {
            answer *= lists.size() + 1;
        }

        return answer-1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "face"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(new Solution().solution(clothes));
    }
}
