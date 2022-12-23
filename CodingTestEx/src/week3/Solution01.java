package week3;

/*
- Graph
- trust[i] = {a, b}는 고유 번호가 a인 사람이 고유 번호가 b인 사람을 믿음
- stream 활용 능력 기르기 (filter, noneMatch 이해하기)
 */

import java.util.Arrays;

public class Solution01 {
    public int solution (int N, int[][] trust) {
        if(trust.length == 0) {
            return -1;
        }

        for (int i = 0; i <= N; i++) {
            int role = i;
            if (Arrays.stream(trust).noneMatch(x -> x[0] == role) &&
                    Arrays.stream(trust).filter(x -> x[1] == role).count() == (N - 1)) {
                return role;
            }
        }
        return -1;
    }
}
