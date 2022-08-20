package Silver.S5;

/*
[MY TIL]
1. 큐를 활용한 요세푸스 순열
2. 단순히 LinkedList로도 구현 가능, 리스트에 남은 데이터 수 주의 요함
3. StringBuilder를 통해 메모리 활용도 높이기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_11866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.add(i); // 큐에 값 다 넣기
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while (queue.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}