import java.util.LinkedList;
import java.util.Queue;

class Solution {

  int times = 0;
  int bridge_length = 0;
  int sum_weight = 0;

  Queue<Integer> trucks = new LinkedList<>();
  Queue<Integer> moving_trucks = new LinkedList<>();

  public int solution(int bridge_length, int weight, int[] truck_weights) {

    this.bridge_length = bridge_length;

    for (int truck_weight : truck_weights) {
      trucks.add(truck_weight);
    }

    while (trucks.size() > 0 || sum_weight != 0) {
      times++;
      if (moving_trucks.size() >= bridge_length) {
        sum_weight -= moving_trucks.remove();
      }

      if ((trucks.size() > 0) && (sum_weight + trucks.peek()) <= weight) {
        Integer new_truck = trucks.remove();
        moving_trucks.add(new_truck);
        sum_weight += new_truck;
      } else {
        moving_trucks.add(0);
      }     
    }

    System.out.println(times);
    return times;
  }
}
