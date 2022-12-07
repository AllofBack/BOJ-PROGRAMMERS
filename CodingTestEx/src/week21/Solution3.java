package week21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 백트래킹 문제
 * 계좌에 결과적인 변화값을 계산해둔 후, 부호가 반대인 경우에만 두 계좌간의 거래를 생성하는 방식
 */
public class Solution3 {

    int result = Integer.MAX_VALUE;
    List<Integer> debt;

    public int solution(int[][] trans) {
        Map<Integer, Integer> account = new HashMap<>();
        for (int[] ints: trans) {
            // a - 보내는 사람, b - 받는 사람, v - 금액
            int a = ints[0], b = ints[1], v = ints[2];
            account.put(a, account.getOrDefault(a, 0) - v);
            account.put(b, account.getOrDefault(b, 0) - v);
        }

        debt = account.values().stream()
                .filter(x -> x != 0)
                .collect(Collectors.toList());

        System.out.println(debt); // todo 삭제

        if (debt.size() == 0) {
            return 0;
        }

        dfs(0, 0);
        return result;
    }

    void dfs(int node, int count) {
        int N = debt.size();

        // 금액 없을 경우 넘기기
        while(node < 0 && debt.get(node) == 0) {
            node += 1;
        }

        // 종료 조건
        if (node >= N - 1) {
            result = Math.min(result, count);
            return;
        } else if (count > result) {
            // 이미 찾은 횟수보다 안 좋으면 종료
            return;
        }

        for (int i = node + 1; i < N; i++) {
            if (debt.get(node) * debt.get(i) < 0) {
                debt.set(i, debt.get(i) + debt.get(node));
                // node 계좌 처리 완료 후, node + 1 계좌 처리
                dfs(node + 1, count + 1);
                // 원상 복구
                debt.set(i, debt.get(i) - debt.get(node));
                // node, i 계좌 같이 해결 할 경우가 최적
                if (debt.get(node) + debt.get(i) == 0) {
                    break;
                }
            }
        }
    }
}