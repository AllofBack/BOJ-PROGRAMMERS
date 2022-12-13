package week21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 시뮬레이션
 * 연결된 블록 찾기 -> DFS
 * 제거해야할 블록 찾기
 */
public class Solution4 {
    int H, W;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 4방향 연결
    int[][] visited; // DFS 방문 여부
    int[][] connectedMap; // 연결된 블록을 1로 표현한 맵
    List<int[]> connectedList; // DFS에서 연결된 블록의 좌표 임시 저장

    public int[][] solution(int[][] board) {
        while (true) {
            // 3개 이상연결된 블록을 찾습니다.
            findConnected(board);

            // 3개 인상 연결된 블록이 하나도 없으면 종료합니다.
            if (Arrays.stream(connectedMap)
                    .flatMapToInt(Arrays::stream)
                    .filter(x -> x > 0)
                    .count() == 0) {
                break;
            }

            // 제거할 블록이 있으면 제거합니다.
            removeConnected(board);
        }

        return board;
    }

    void findConnected(int[][] board) {
        H = board.length;
        W = board[0].length;

        visited = new int[H][W];
        connectedMap = new int[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 방문한 적 없는 0이 아닌 블록 -> DFS 수행
                if (board[i][j] != 0 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    connectedList = new ArrayList<>();
                    connectedList.add(new int[]{i, j});

                    dfs(board, i, j);

                    if (connectedList.size() >= 3) {
                        for (int[] ints : connectedList) {
                            connectedMap[ints[0]][ints[1]] = 1;
                        }
                    }
                }
            }
        }
    }

    void dfs(int[][] board, int i, int j) {
        for (int[] ints: directions) {
            int newI = i + ints[0];
            int newJ = j + ints[1];

            // 4방향 중 같은 블록이면서 방문하지 않았으면 연결후 DFS 수행
            if ((0 <= newI && newI < H) &&
                    (0 <= newJ && newJ < W) &&
                    (visited[newI][newJ] == 0) &&
                    (board[i][j] == board[newI][newJ])) {
                visited[newI][newJ] = 1;
                connectedList.add(new int[]{newI, newJ});
                dfs(board, newI, newJ);
            }
        }
    }

    // 제거할 블록을 찾으면, 해당 블록 위쪽을 한칸씩 내리는 방식으로 구현
    void removeConnected(int[][] board) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (connectedMap[i][j] == 1) {
                    for (int k = i; k >= 0; k--) {
                        if (k == 0) {
                            board[k][j] = 0;
                        } else {
                            board[k][j] = board[k-1][j];
                        }
                    }
                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 3, 0},
                {0, 1, 2, 3, 4, 4},
                {1, 2, 3, 4, 4, 4}};
        int[][] sol = new Solution4().solution(board);

        for (int[] line: sol) {
            System.out.println(Arrays.toString(line));
        }
    }
}
