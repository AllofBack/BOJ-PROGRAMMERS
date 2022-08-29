package Bronze.B1;

/*
[MY TIL]
1. 최대공약수를 구할 때, GCD 방식 사용하기
2. GCD는 가장 큰 공통된 약수를 의미한다. (r : 나머지)
3. a와 b의 최대공약수를 (a,b)라 할 때, (a, b)의 최대공약수는 (b,r)의 최대공약수와 같다.
4. 재귀 & 반복문 둘 다 사용 가능
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class b_2609 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int d = gcd(a, b);	// 최대공약수

        System.out.println(d);
        System.out.println(a * b / d);

    }

    // 최대공약수 재귀 방식
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;

        // GCD(a, b) = GCD(b, r)이므로 (r = a % b)
        return gcd(b, a % b);
    }
}