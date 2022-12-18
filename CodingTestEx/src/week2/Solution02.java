package week2;

import java.util.Stack;

public class Solution02 {
    public int[] solution(int[] a, int[] b) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = Math.max(a.length, b.length);
        int offsetA = maxLen - a.length;
        int offsetB = maxLen - b.length;

        if (a.length == 0) {
            return b;
        }

        if (b.length == 0) { // 엣지 케이스 고려하기
            return a;
        }

        int overflow = 0;
        for (int i = maxLen - 1; i >= 0; i--) { // 맨 끝부터 자릿수 계산
            int aVal = (i - offsetA < 0) ? 0 : a[i - offsetA];
            int bVal = (i - offsetB < 0) ? 0 : b[i - offsetB];
            int cVal = aVal + bVal + overflow;
            if (cVal >= 10) {
                overflow = 1;
                stack.push(cVal - 10);
            } else {
                stack.push(cVal);
            }
        }

        int resLen = maxLen;
        if (overflow == 1) { // 마지막 자릿수
            resLen++;
            stack.push(1);
        }

        int[] result = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
