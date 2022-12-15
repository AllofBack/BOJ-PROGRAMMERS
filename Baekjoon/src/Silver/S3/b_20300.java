package Silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
- 운동 기구 최대 2개 사용 가능
- 운동기구마다 근손실이 다름.
- 홀수 일 경우, 제일 큰거 빼고 좌우 줄여가며 사용
- 짝수일 경우, 가장 큰 값과 작은 값
 */
public class b_20300 {
    static int N; // 운동기구 개수
    static long[] list; // 근 손실 정도

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            list[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(list);
        long max = Long.MIN_VALUE;

        if (N % 2 == 0) {
            for (int i = 0; i < (N / 2) + 1; i++) {
                max = Math.max(max, list[i] + list[N - i - 1]);
            }
        } else {
            max = list[N - 1];
            for (int i = 0; i < (N / 2) + 1; i++) {
                max = Math.max(max, list[i] + list[N - i - 2]);
            }
        }
        System.out.println(max);
    }
}
