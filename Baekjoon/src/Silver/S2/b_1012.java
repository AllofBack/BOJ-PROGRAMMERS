package Silver.S2;

/*
- DFS / BFS
- 상하좌우로 이동하면서 4방면 탐색 진행
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1012 {
    static int W;
    static int H;
    static int K; // 배추 심어져 있는 위치 개수

    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1}; // 상하좌우

    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            map = new int[W][H];
            visit = new boolean[W][H];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            
            int count = 0; // 구역 수

            for (int j = 0; j < W; j++) {
                for (int k = 0; k < H; k++) {
                    if (map[j][k] == 1 && !visit[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    
    public static void dfs(int r, int c) {
        visit[r][c] = true; // 방문 확인

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr >= 0 && nc >= 0 && nr < W && nc < H) {
                if (map[nr][nc] == 1 && !visit[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
