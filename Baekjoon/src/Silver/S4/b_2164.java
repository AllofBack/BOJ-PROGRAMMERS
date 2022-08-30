package Silver.S4;

/*
[MY TIL]
1. 카드를 순서대로 놓고, 가장 위 카드 버리고 그다음 카드는 가장 아래로 옮기는 행위 반복
2. Queue를 활용하여 해결할 수 있다.
3. isEmpty로 확인해주지 않으면 NullPointerError 발생한다.
4. 다른 풀이를 확인해보니, 큐 말고 일반 배열 사용해서 값 대입해주는게 시간적으로는 더 효율적이다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b_2164 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        if (!queue.isEmpty()) {
            while(queue.size() > 1) {
                queue.poll();
                if (!queue.isEmpty()) {
                    int n = queue.poll();
                    queue.add(n);
                }
            }
        }
        System.out.println(queue.poll());
    }
}
