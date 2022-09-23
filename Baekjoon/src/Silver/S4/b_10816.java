package Silver.S4;

/*
[MY TIL]
1. 처음에 HashMap하고 단순 counting을 사용하니, 문제는 풀어졌지만 시간이 매우 오래걸림
2. 이분 탐색 사용 문제! 중간 위치와 key(찾고자 하는 값) 비교하여 구간 절반 줄여나가며 풀기
3. a[mid] == key일 경우, 반환하기. 중복 원소에 대한 길이 (upper - lower)
*/

import java.io.*;
import java.util.*;

public class b_10816 {

    public static int lower(int n, int a[], int k) {
        int start = 0, end = n - 1, mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if (a[mid] >= k) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return start;
    }

    public static int upper(int n, int a[], int k) {
        int start = 0, end = n - 1, mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if (a[mid] > k) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());

            sb.append(upper(n, a, key) - lower(n, a, key)).append(' ');
        }
        System.out.println(sb);
    }
}
