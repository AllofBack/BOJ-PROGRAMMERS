package Silver.S3;

/*
[MY TIL]
1. 다이나믹 프로그래밍 - top-down / bottom-up 두가지 케이스 계산 방법 둘 다 이해하기
2. 바텀업의 경우,
 1. i-1로 뺴준 연산 횟수에 +1  dp[i] = dp[i-1] +1;
 2. i/2로 나눈 수의 연산값과 1번에서 구한 연산값 중 최솟값 if(i%2==0)
 3. i/3 로 나눈 수의 연산값과 1번에서 구한 연산값 중 최솟값 if(i%3==0)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1463 {
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        toOne(n,0);
        System.out.println(ans);
    }

    static void toOne(int num, int cnt) {
        if(num==1) {
            ans = Math.min(ans, cnt);
            return;
        }

        if(cnt >= ans) return;

        if(num%3==0) {
            toOne(num/3, cnt+1);
        }
        if(num%2 ==0) {
            toOne(num/2, cnt+1);
        }
        toOne(num-1, cnt+1);
    }
    /*
    // Bottom - up
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= N ; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[N]);
        br.close();
    }

     */
}
