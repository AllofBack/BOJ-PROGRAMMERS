package Silver.S2;

/*
[MY TIL]
1. DFS는 재귀를 사용하였지만 스택으로도 해결 가능
1. BFS는 큐를 이용해 해결하였다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_1260 {
    
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    
    static int node, line, start;
    
    static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        
        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stt.nextToken());
            int b = Integer.parseInt(stt.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");
        check = new boolean[node+1];

        bfs(start);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        check[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) dfs(i);
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start).append(" ");

            for (int i = 0; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
