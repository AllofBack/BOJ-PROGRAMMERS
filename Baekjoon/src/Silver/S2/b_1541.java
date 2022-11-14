package Silver.S2;

/*
[MY TIL]
1. 최솟값을 만들기 위해서는 최대한 큰 수를 먼저 만들어야한다.
2. 덧셈으로 이루어진 부분을 먼저 계산한 뒤 빼주기
3. split 사용시 + 메타분자 => PatternSyntaxException 발생 주의 \\+ 로 받기
4. StringTokenizer로 해결하기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while (st.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer add = new StringTokenizer(st.nextToken(), "+");

            while (add.hasMoreTokens()) {
                temp += Integer.parseInt(add.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
