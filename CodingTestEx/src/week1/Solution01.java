package week1;

/*
1. 에라토스테네스의 체
2. 소수가 아닌 수들을 순차적으로 배제하는 방식
3. 일정 숫자를 넘어서는 검사할 필요가 없다.
 */

import java.util.Arrays;

class Solution01 {
    public int solution(int n) {

        int[] intArrray = new int[n];

        for (int i = 2; i < n ; i++) {
            intArrray[i] = 1;
        }

        for (int i = 2; i <= (int)Math.sqrt(n) ; i++) {
            if (intArrray[i] == 0) continue;

            int num = i * 2;
            while(num < n) {
                intArrray[num] = 0;
                num += 1;
            }
        }
        return Arrays.stream(intArrray).sum();
    }
}
