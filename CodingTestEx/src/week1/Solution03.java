package week1;

/*
- 재귀는 가독성만 좋고, 반복이 속도가 빠르고 메모리도 더 적게 사용!
- f(n) = f(n-1) + f(n-2)
- f(1) = 1, f(2) = 2
 */

public class Solution03 {
    public int solution (int N) {
        int a = 1, b = 2;

        if (N == 1) {
            return a;
        }

        for (int i = 3; i <= N; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
