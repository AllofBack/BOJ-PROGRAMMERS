package Silver.S2;

/*
- 이진 트리가 아니라 연결된 그래프 구조!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_11725 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 트리 구조 표현을 위한 그래프
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        boolean[] visited = new boolean[n];
        int[] parentNode = new int[n];

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for(int node : tree.get(v)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parentNode[node] = v;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.println(parentNode[i] + 1);
        }

    }
}
