package week1;

/*
- 중요 ✨✨✨
- 디귿자 배치. 2차원 내 4개의 부분 배열 생성
- 재귀적으로 해결하기 (너비 최적화)
- i, j에 대해 계속해서 새 입력을 받아야한다.
- 구역을 나누기 때문에 답을 도출하고자하는 구역이 아닐 경우, 그 안의 모든 수를 알 필요 없다!
 */

public class Solution04 {
    public int solution (int n, int i, int j) {
        return recursion(0, n, i, j);
    }

    private int recursion(int count, int n, int i, int j) {
        // n = 2인 경우 탈출 조건
        if (n == 2) {
            if (i == 0 & j == 1) {
                return count + 1;
            } else if (i == 0 & j == 0) {
                return count + 2;
            } else if (i == 1 & j == 0) {
                return count + 3;
            } else {
                return count + 4;
            }
        }

        // 4개 영역으로 나누어 count offset 계산
        int m = n / 2;
        if (i < m & j >= m) { // 우측 상단
            return recursion(count, m, i, j - m);
        } else if (i < m & j < m) { // 좌측 상단
            count += m * m;
            return recursion(count, m, i, j);
        } else if (i >= m & j < m) { // 좌측 하단
            count += m * m * 2;
            return recursion(count, m, i - m, j);
        } else { // 우측하단
            count += m * m * 3;
            return recursion(count, m, i - m, j - m);
        }
    }
}
