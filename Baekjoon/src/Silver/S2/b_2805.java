package Silver.S2;

/*
[MY TIL]
1. 이분 탐색 Upper bound 방식
2. max : tree에 저장 된 나무들 중 가장 큰 나무 높이
3. 하한선이 상한선보다 커지면 더이상 이분탐색 진행 X
4. Upper Bound 방식으로 진행하면 최종적으로 +1 하기 때문에 결과값에서 -1해줘야함.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_2805 {

    public static void main(String[] args) throws IOException {

        // 절단기에 높이 H 지정
        // 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라감
        // 한 줄에 연속해 있는 나무 모두 절단
        // 높이가 H보다 큰 나무는 H위의 부분이 잘림, 낮은 나무는 잘리지 않음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

            if (max < trees[i]) max = trees[i];
        }

        while ( min < max ) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree - mid > 0) sum += (tree - mid);
            }

            if (sum < M) max = mid;
            else min = mid + 1;
        }

        System.out.println(min - 1);
    }
}
