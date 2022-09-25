package Platinum.P5;

/*
[MY TIL]
1. 일반 이진탐색트리 방법으로는 시간초과 발생,,TreeSet의 lower과 higher 메소드 사용하기
2. 작은 수와 큰 수의 위치 중 더 깊은 수 선택해 그 밑에 위치시켜야한다.
3. 카운트 출력 위치 주의
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class b_2957 {
    static int N;
    static long count = 0;
    static int depth[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        depth = new int[N+2];

        // TreeSet : 이진탐색 트리
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        treeSet.add(N+1);

        depth[0] = -1;
        depth[N+1] = -1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // lower : 해당 객체 바로 아래 객체
            // higher : 해당 객체 바로 위에 있는 객체
            depth[num] = Math.max(depth[treeSet.lower(num)], depth[treeSet.higher(num)]) + 1;
            treeSet.add(num);

            count += depth[num];
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
