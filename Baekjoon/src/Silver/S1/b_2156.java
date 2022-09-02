package Silver.S1;

/*
[MY TIL]
1. 다이나믹 프로그래밍 - 3잔을 연속해서 마실 수 없기 때문에 oox, oxo, xoo 경우 중 판단하기
2. [6, 10, 13, 9, 8, 1]일 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔 선택 => 33
3. dp[0], dp[1], dp[2]는 예외 처리 진행
4. 최대가 되는 로직을 잘 짜보자
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] grapes = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            grapes[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = grapes[0];

        for (int i = 1; i < N; i++) {
            if (i == 1) {
                dp[1] = grapes[0] + grapes[1];
                continue;
            }
            if (i == 2) {
                dp[2] = Math.max(dp[1], Math.max(grapes[0] + grapes[2], grapes[1] + grapes[2] ));
                continue;
            }
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i-2] + grapes[i], dp[i-3] + grapes[i-1] + grapes[i]));
        }
        System.out.println(dp[N-1]);
    }
}
