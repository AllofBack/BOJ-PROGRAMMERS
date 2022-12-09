package Silver.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[MY TIL]
1. 그리디 문제
2. (받은 등수 - 1) 이 최대한 작아야하고 생각했던 돈은 커야한다.
3. 주려고 생각한 돈이 큰 사람을 앞 쪽에 두기
*/
public class b_1758 {
    static int n;
    static int[] list;
    static long totalTip;
    static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        for (int i = list.length - 1; i >= 0 ; i--) {
            int tip = list[i] - (idx - 1);
            if (tip > 0) {
                totalTip += tip;
            }
            idx++;
        }

        System.out.println(totalTip);
    }
}
