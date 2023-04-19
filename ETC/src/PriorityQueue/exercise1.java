package PriorityQueue;

import java.util.PriorityQueue;

public class exercise1 {
  public static void solution(int[] stones) {
    PriorityQueue pq = new PriorityQueue<Integer>((x, y) -> y - x); // 내림차순

    for (int stone : stones) {
      pq.offer(stone);
    }

    // 돌 두개를 꺼내서 비교 후 차이만큼 추가
    while (pq.size() > 1) {
      int stone1 = pq.poll();
      int stone2 = pq.poll();
      int diff = Math.abs(stone1 - stone2);

      if (diff != 0) {
        pq.offer(diff);
      }
      System.out.println(pq.poll());
    }
  }

  public static void main(String[] args) {
    // Test code
    int[] stones = { 2, 7, 4, 1, 8, 1 };
    solution(stones);

    stones = new int[] { 5, 3, 5, 3, 4 };
    solution(stones);
  }

}
