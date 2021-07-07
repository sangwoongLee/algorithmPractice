import java.util.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int cursor = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            int sum = 100 - progresses[i];
            if(sum % speeds[i] == 0 )  queue.add((int)(sum / speeds[i]));
            else queue.add((int)(sum / speeds[i])+1);

        }

        int lastNum = queue.remove();
        int count = 1;

        while(!queue.isEmpty()) {
            if(lastNum >= queue.peek()) {
                count++;
                queue.remove();
            }
            else{
                lastNum = queue.remove();
                answer.add(count);
                count = 1;
            }
        }
        answer.add(count);

        for(Integer a: answer)
            System.out.println(a);

        return answer.stream().mapToInt(i->i).toArray();
    }
}
