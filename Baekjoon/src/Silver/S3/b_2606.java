package Silver.S3;

/*
[MY TIL]
1. 입력 받고 인접 행렬에 값 넣어주기
2. DFS 실행 -> 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_2606 {

    static boolean[] check;
    static int[][] arr;
    static int count = 0;
    static int computerN, coupleNum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerN = Integer.parseInt(br.readLine());
        coupleNum = Integer.parseInt(br.readLine());

        arr = new int[computerN+1][computerN+1];
        check = new boolean[computerN+1];

        for (int i = 0; i < coupleNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int firstNum = Integer.parseInt(st.nextToken());
            int nextNum = Integer.parseInt(st.nextToken());

            arr[firstNum][nextNum] = arr[nextNum][firstNum] = 1;
        }

        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int start){
        check[start] = true;
        count++;

        for (int i = 0; i <= computerN; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}
