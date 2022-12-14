package Silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[MY TIL]
- Greedy 문제
- 절반 버리는 경우를 가장 작은 것부터 해결해야지 최대로 만들 수 있다.
*/

public class b_20115 {
    static int N;
    static int[] list;
    static float result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);
        result = list[N - 1];

        for (int i = 0; i < N - 1 ; i++) {
            result += (float)list[i] / 2 ;
        }

        System.out.println(result);
    }
}
