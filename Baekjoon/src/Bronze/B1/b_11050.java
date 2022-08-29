package Bronze.B1;

/*
[MY TIL]
1. 이항 계수 N, K에 대하여 N >= K>= 0 일경우 N! / (N!(N-K)!) 계산
2. N, K의 값에 따라 이항 계수는 다른 연산을 행하지만 문제에서 제한을 두었기 때문에 위 조건만 해결하면 됨
3. 조합의 연산이 포함되어 있다. 이를 이용하자!
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b_11050 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cal = br.readLine().split(" ");

        int N = Integer.parseInt(cal[0]);
        int K = Integer.parseInt(cal[1]);

        int uResult = 1;
        int dResult = 1;

        for (int i = N; i >= N - K + 1; i--) {
            uResult *= i;
        }

        for (int i = 1; i <= K; i++) {
            dResult *= i;
        }

        System.out.println(uResult / dResult);
    }
}
