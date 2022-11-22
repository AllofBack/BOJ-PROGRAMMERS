package Gold.G5;

/*
[MY TIL]
1. 완전 탐색
2. N까지 + 또는 - 버튼으로만 움직이는 경우
3. N과 가까운 번호를 누른 후, + 또는 - 버튼으로 움직이는 경우
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1107 {

    static int target;
    static int brokenNum;
    static int result;
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());
        brokenNum = Integer.parseInt(br.readLine());

        if (brokenNum > 0) {
            String [] inputs = br.readLine().split(" ");
            for (int i = 0; i < brokenNum; i++) {
                broken[Integer.parseInt(inputs[i])] = true;
            }
        }

        result = Math.abs(target - 100);

        for (int i = 0; i < 1000000; i++) {
            int len = check(i);
            if (len > 0) {
                int press = Math.abs(target - i);  // +,- 버튼 누르는 횟수
                result = Math.min(result, len + press);   // 최소 이동 횟수 계산
            }
        }

        System.out.print(result);
    }
    static int check(int c) {
        if (c == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) {
                return 0;
            }
            c /= 10;
            len += 1;
        }
        return len;
    }
}
