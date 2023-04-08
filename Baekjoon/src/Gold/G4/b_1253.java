package Gold.G4;

/*
 * 문제 : 좋다 / 난이도 : Gold4
 * 투포인터 활용하기
 * 둘 다 시작점으로 하면 안 풀린다. 처음과 끝으로 나눠서 해보기
 *
 * 메모리 : 14684KB / 시간 : 180MS
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1253 {
    static int N;
    static int[] list;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int idx = 0;
        while (st.hasMoreTokens()) {
            list[idx++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        for (int i = 0; i < N; i++) {
            int curNum = list[i];

            int start = 0;
            int end = N - 1;
            int sum = 0;

            while (start < end) {
                sum = list[start] + list[end];
                if (sum == curNum) {
                    if (i == start) start++;
                    else if (end == i) {
                        end--;
                    } else {
                        answer++;
                        break;
                    }
                }

                if (list[start] + list[end] > curNum) {
                    end--;
                } else if (list[start] + list[end] < curNum) {
                    start++;
                }
            }

        }
        System.out.println(answer);
    }
}
