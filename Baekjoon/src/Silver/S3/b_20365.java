package Silver.S3;

/*
- 최소한의 방법으로 하기 위해선, 더 많은 색깔로 전체 먼저 칠하고
- 적은 개수의 색깔을 해당하는 위치에 덧칠하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b_20365 {
    static int N;
    static int answer = 0;
    static String line;
    static List<String> bList;
    static List<String> rList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bList = new ArrayList<>();
        rList = new ArrayList<>();

        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, "R");

        while (st.hasMoreTokens()) {
            bList.add(st.nextToken());
        }

        st = new StringTokenizer(line, "B");

        while (st.hasMoreTokens()) {
            rList.add(st.nextToken());
        }

        if (rList.size() >= bList.size()) {
            answer = bList.size() + 1;
        } else {
            answer = rList.size() + 1;
        }

        System.out.println(answer);
    }
}
