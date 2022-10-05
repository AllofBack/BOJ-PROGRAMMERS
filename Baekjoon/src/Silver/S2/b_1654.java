package Silver.S2;

/*
[MY TIL]
1. 이분 탐색 Upper bound 방식
2. max : 랜선 길이 중 가장 길 길이
3. 가장 중요 **max+1** 꼭 필요 => 입력 받는 랜선에서 최대 길이 + 1를 max 값으로 잡아줘야 mid 0 상황 방지
4. Upper Bound 방식으로 진행하면 최종적으로 +1 하기 때문에 결과값에서 -1해줘야함.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1654 {

    public static void main(String[] args) throws IOException {
        // 오영식 이미 k개의 랜선 있음
        // k개의 랜선 길이 제각각
        // 박성원 랜선 모두 N개의 같은 길이로 만들고 싶어함.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lens = new int[K];

        long min = 0;
        long max = 0;

        for (int i = 0; i < K; i++) {
            lens[i] = Integer.parseInt(br.readLine());

            if (max < lens[i]) max = lens[i];
        }

        max++;

        while (min < max) {

            long mid = (min + max) / 2;
            long cnt = 0;

            for (int len : lens) {
                long now = len / mid;
                cnt += now;
            }

            if (cnt < N) max = mid;
            else min = mid + 1;
        }

        System.out.println(min - 1);
    }
}
