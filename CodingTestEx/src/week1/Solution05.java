package week1;

import java.util.Arrays;

/*
- 중요 ✨✨✨
- 합과 곱의 처리
- 공간에 대한 정보가 변수로 주어져 까다로움
- 학생 수보다 공간이 더 많은 경우 주의하기
- 몇 중 for문을 해야할 지 모르기 때문에 학생 배치 교실의 경우의 수를 전체 경우의 수로 확장해서 구하기
 */

public class Solution05 {
    public long solution (int N, int M, int K, int[] capacity) {
        int capacitySum = Arrays.stream(capacity).sum();

        long studentCases = 1;

        if (capacitySum == N) {
            int studentLeft = N;
            for (int cap : capacity) {
                studentCases *= nChooseK(studentLeft, cap);
                studentLeft -= cap;
            }
        } else {
            studentCases = 0;
            // 전체 경우의 수로 확장하기
            long capacityMult = Arrays.stream(capacity).asLongStream().
                    reduce(1, (x, y) -> x*(y+1)); // 숫자를 하나씩 줄여나가는 방법

            indexLoop:
            for (int i = 0; i < capacityMult; i++) { // 자릿수 올리기
                int[] caps = new int[M];
                long denominator = capacityMult;
                long numerator = i;
                int currentSum = 0;
                for (int j = 0; j < M; j++) {
                    denominator /= capacity[j] + 1;
                    caps[j] = (int)(numerator / denominator);
                    numerator %= denominator;

                    currentSum += caps[j];
                    if (currentSum > N) { // 학생 수보다 많은 경우라면 넘김
                        continue indexLoop;
                    }
                }

                long currentCase = 1;
                if (Arrays.stream(caps).sum() == N) { // 학생 수와 일치하는 경우를 계산
                    int studentLeft = N;
                    for (int cap: caps) {
                        currentCase *= nChooseK(studentLeft, cap);
                        studentLeft -= cap;
                    }
                    studentCases += currentCase;
                }
            }
        }
        long kPm = 1; // 감독관
        for (int i = K-M+1; i <= K; i++) {
            kPm *= i;
        }
        return studentCases * kPm;
    }
    private long nChooseK (int n, int k) {
        long numerator = 1;
        long denominator = 1;
        for (int i = 0; i < k; i++) {
            numerator *= n - i;
            denominator *= i + 1;
        }
        return numerator / denominator;
    }
}
