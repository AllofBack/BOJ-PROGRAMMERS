package Gold.G4;

/*
[MY TIL]
1. 정렬된 두 묶음의 숫자 카드 (A,B)
2. 단순하게 작은 수끼리 먼저 더하면 해결될거라고 생각했지만, 그렇게 하면 오답
3. 더한 값이 기존 값보다 클 수 있기 때문에 우선순위 큐 사용
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b_1715 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();

            sum += num1 + num2;
            pq.add(num1 + num2);
        }
        System.out.println(sum);
    }
}
