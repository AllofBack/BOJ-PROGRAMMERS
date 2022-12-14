package week1;

import java.util.*;
public class Solution02 {
    public int solution(String[] names) {
        // 중복제거 - set 사용
        Set<String> set = new HashSet<>(Arrays.asList(names));
        int n = set.size();
        int m = 4;

        int numerator = 1;
        int denominator = 1;
        for (int i = 0; i < m; i++) {
            numerator *= n - i; // 분자 쪽 4개
            denominator *= (i + 1); // 분모 쪽 4개로 생각해서 조합 사용
        }

        return numerator / denominator; // 뽑기는 순서가 상관없기 때문에 나눠줌.
    }
}
