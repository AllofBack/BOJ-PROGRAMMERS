package Gold.G5;

/*
[MY TIL]
- DFS / 그래프
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_10026 {

    static int size;
    static int[] moveX = {0, 1, 0, -1};	// 상, 우, 하, 좌
    static int[] moveY = {-1, 0, 1, 0};
    static int[][] pictures, patient;
    static char[][] grid;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());

        pictures = new int[size][size];
        patient = new int[size][size];
        grid = new char[size][];

        for (int i = 0; i < size; i++) {
            String curLine = br.readLine();
            grid[i] = curLine.toCharArray();
        }

        int count = 0, patientCount = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (pictures[i][j] == 0) {
                    count++;
                    dfs(i, j, grid[i][j], count);
                }

                if (patient[i][j] == 0){
                    patientCount++;
                    patientDFS(i, j, grid[i][j], count);
                }
            }
        }
        System.out.println(count + " " + patientCount);
    }

    static void patientDFS(int y, int x, char color, int count) {
        patient[y][x] = count;

        for (int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if(nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) {
                continue;
            }

            if(patient[nextY][nextX] != 0) { // 이미 탐색한 곳인 경우 넘기기
                continue;
            }

            char nextColor = grid[nextY][nextX];
            if(nextColor == color) {
                patientDFS(nextY, nextX, nextColor, count);
            }
            else {
                if((color == 'R' && nextColor == 'G') || (color == 'G' && nextColor == 'R')) {
                    patientDFS(nextY, nextX, nextColor, count);
                }
            }
        }
    }

    // 적록색약인 사람이 아닌 경우
    static void dfs(int y, int x, char color, int count) {
        pictures[y][x] = count;

        for(int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if(nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) {
                continue;
            }

            if(pictures[nextY][nextX] != 0) { // 이미 탐색한 곳인 경우 넘기기
                continue;
            }

            char nextColor = grid[nextY][nextX];
            if(nextColor == color) {
                dfs(nextY, nextX, nextColor, count);
            }
        }
    }
}
