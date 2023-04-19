package Silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// N개의 정점과 M개ㅔ의 간선의 무방향그래프

public class b_24480 {
  static int N, M, R, cnt;
  static ArrayList<ArrayList<Integer>> dfs = new ArrayList<>();
  static int[] visited; // 방문한 정점을 기록할 배열

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken()); // 정점 수
    M = Integer.parseInt(st.nextToken()); // 간선 수
    R = Integer.parseInt(st.nextToken()); // 시작 정점

    visited = new int[N + 1];
    for (int i = 0; i < N + 1; i++) {
      dfs.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      dfs.get(u).add(v);
      dfs.get(v).add(u);
    }

    for (ArrayList<Integer> d : dfs) { // 내림차순
      Collections.sort(d, Collections.reverseOrder());
    }

    cnt = 1;
    dfs(R);

    for (int i = 1; i < visited.length; i++) {
      System.out.println(visited[i]);
    }
  }

  public static void dfs(int start) {
    visited[start] = cnt;
    for (int i = 0; i < dfs.get(start).size(); i++) {
      int newNode = dfs.get(start).get(i);
      if (visited[newNode] == 0) {
        cnt++;
        dfs(newNode);
      }
    }
  }
}
