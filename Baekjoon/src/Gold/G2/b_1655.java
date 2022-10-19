package Gold.G2;

/*
[MY TIL]
1. 계속해서 중간값 말하기
2. 외친 수가 짝수개이면, 중간에 있는 두 수 중 작은 수 말하기
3. 처음에 우선순위큐 1개만 선언해서 하려니까 해결법을 도저히 모르겠어서 한참을 걸렸다.
4. 2개의 우선순위큐 선언해서, 두 우선순위 큐 크기가 같으면 max거 출력, 다르면 min거 출력
5. max Top에 위치한 값이 중간값임.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(maxPQ.size() == minPQ.size()) maxPQ.offer(num);
            else minPQ.offer(num);

            if(!maxPQ.isEmpty() && !minPQ.isEmpty()) {
                if(maxPQ.peek() > minPQ.peek()) {
                    minPQ.offer(maxPQ.poll());
                    maxPQ.offer(minPQ.poll());
                }
            }
            sb.append(maxPQ.peek()).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}