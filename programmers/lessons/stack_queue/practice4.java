import java.util.*;

# 프로그래머스 문제 - 주식거래

class Solution {
    class Data{
        Integer time;
        Integer price;
        Data(Integer time, Integer price){
            this.time = time;
            this.price = price;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Data> stack = new Stack();

        int now = 0;

        for(int price: prices){
            while(!stack.isEmpty() && price < stack.peek().price){
                int current = stack.pop().time;
                answer[current] = now - current;
            }
            
            stack.push(new Data(now, price));
            now++;
        }

        while(!stack.isEmpty()) {
            int current = stack.pop().time;
            answer[current] = now-current-1;
        }

        return answer;
    }
}
