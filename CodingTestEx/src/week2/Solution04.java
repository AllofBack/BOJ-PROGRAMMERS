package week2;

/*
- Message Queue
- 하나의 메세지 처리 -> delay(ms) 소요
- 큐의 용량 capacity
- 처리하는 순간 큐에서 제거, 큐 가득차있으면 입력된 메세지 소실
- 입력 제거 동시에 일어날 경우, 제거 먼저
- 메세지 전달 간격 - times 배열
 */

public class Solution04 {
    public int solution(int delay, int capacity, int[] times) {
        int curTime = 0;
        int curQueue = 0;
        int result = 0;
        for (int time : times) {
            curTime += time; // 현재 누적 시간
            int sent = curTime / delay;
            curQueue = Math.max(0, curQueue - sent); // 현재 큐 상태
            if (curQueue == capacity) { // 가득 찼을 경우
                result++; // 초과
            } else {
                curQueue++;
            }
            curTime %= delay;
        }
        return result;
    }
}
