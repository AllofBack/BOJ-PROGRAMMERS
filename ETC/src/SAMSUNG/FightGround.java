package SAMSUNG;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Player {
  int num, x, y, d, s, a;

  public Player(int num, int x, int y, int d, int s, int a) {
    this.num = num;
    this.x = x;
    this.y = y;
    this.d = d;
    this.s = s;
    this.a = a;
  }
}

class Tuple {
  int x, y, dir;

  public Tuple(int x, int y, int dir) {
    this.x = x;
    this.y = y;
    this.dir = dir;
  }
}

class Pair {
  int x, y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean isSame(Pair p) {
    return this.x == p.x && this.y == p.y;
  }
}

public class FightGround {
  public static final Player EMPTY = new Player(-1, -1, -1, -1, -1, -1);
  public static final int DIR_NUM = 4;
  public static final int MAX_M = 30;
  public static final int MAX_N = 20;

  // 변수 선언
  public static int n, m, k;

  // 각 칸마다 놓여있는 총 목록을 관리합니다.
  public static ArrayList<Integer>[][] gun = new ArrayList[MAX_N][MAX_N];

  // 각 칸마다 플레이어 정보를 관리합니다.
  // 순서대로 (num, x, y, d, s, a) 정보를 관리합니다.
  // (x, y)위치에서 방향 d를 보고 있으며
  // 초기 능력치가 s인 num번 플레이어가
  // 공격력이 a인 총을 들고 있음을 뜻합니다.
  // 총이 없으면 a는 0입니다.
  public static Player[] players = new Player[MAX_M];

  // 입력으로 주어지는
  // 방향 순서대로
  // dx, dy를 정의합니다.
  // ↑, →, ↓, ←
  public static int[] dx = new int[] { -1, 0, 1, 0 };
  public static int[] dy = new int[] { 0, 1, 0, -1 };

  // 플레이어들의 포인트 정보를 기록합니다.
  public static int[] points = new int[MAX_M];

  // (x, y)가 격자를 벗어나는지 확인합니다.
  public static boolean inRange(int x, int y) {
    return 0 <= x && x < n && 0 <= y && y < n;
  }

  // 현재 (x, y)위치에서 방향 d를 보고 있을 때
  // 그 다음 위치와 방향을 찾아줍니다.
  public static Tuple getNext(int x, int y, int d) {
    int nx = x + dx[d], ny = y + dy[d];
    // 격자를 벗어나면
    // 방향을 뒤집어
    // 반대 방향으로 한 칸 이동합니다.
    if (!inRange(nx, ny)) {
      // 반대 방향 : 0 <-> 2 / 1 <-> 3
      d = (d < 2) ? (d + 2) : (d - 2);
      nx = x + dx[d];
      ny = y + dy[d];
    }

    return new Tuple(nx, ny, d);
  }

  // 해당 칸에 있는 Player를 찾아줍니다.
  // 없다면 EMPTY를 반환합니다.
  public static Player findPlayer(Pair pos) {
    for (int i = 0; i < m; i++) {
      int x = players[i].x, y = players[i].y;
      if (pos.isSame(new Pair(x, y)))
        return players[i];
    }

    return EMPTY;
  }

  // Player p의 정보를 갱신해줍니다.
  public static void update(Player p) {
    int num = p.num;

    // Player의 위치를 찾아
    // 값을 갱신해줍니다.
    for (int i = 0; i < m; i++) {
      int numI = players[i].num;
      if (numI == num) {
        players[i] = p;
        break;
      }
    }
  }

  // 플레이어 p를 pos 위치로 이동시켜줍니다.
  public static void move(Player p, Pair pos) {
    int num = p.num, x = p.x, y = p.y, d = p.d, s = p.s, a = p.a;
    int nx = pos.x, ny = pos.y;

    // 가장 좋은 총으로 갱신해줍니다.
    gun[nx][ny].add(a);
    Collections.sort(gun[nx][ny]);
    a = gun[nx][ny].get(gun[nx][ny].size() - 1);
    gun[nx][ny].remove(gun[nx][ny].size() - 1);

    p = new Player(num, nx, ny, d, s, a);
    update(p);
  }

  // 진 사람의 움직임을 진행합니다.
  // 결투에서 패배한 위치는 pos입니다.
  public static void loserMove(Player p) {
    int num = p.num, x = p.x, y = p.y, d = p.d, s = p.s, a = p.a;

    // 먼저 현재 위치에 총을 내려놓게 됩니다.
    gun[x][y].add(a);

    // 빈 공간을 찾아 이동하게 됩니다.
    // 현재 방향에서 시작하여
    // 90'씩 시계방향으로
    // 회전하다가
    // 비어있는 최초의 곳으로 이동합니다.
    for (int i = 0; i < 4; i++) {
      int ndir = (d + i) % 4;
      int nx = x + dx[ndir], ny = y + dy[ndir];
      if (inRange(nx, ny) && findPlayer(new Pair(nx, ny)) == EMPTY) {
        p = new Player(num, x, y, ndir, s, 0);
        move(p, new Pair(nx, ny));
        break;
      }
    }
  }

  // p2과 p2가 pos에서 만나 결투를 진행합니다.
  public static void duel(Player p1, Player p2, Pair pos) {
    int num1 = p1.num, d1 = p1.d, s1 = p1.s, a1 = p1.a;
    int num2 = p2.num, d2 = p2.d, s2 = p2.s, a2 = p2.a;

    // (초기 능력치 + 총의 공격력, 초기 능력치) 순으로 우선순위를 매겨 비교합니다.

    // p1이 이긴 경우
    if (s1 + a1 > s2 + a2 || (s1 + a1 == s2 + a2 && s1 > s2)) {
      // p1은 포인트를 얻게 됩니다.
      points[num1] += (s1 + a1) - (s2 + a2);
      // p2는 진 사람의 움직임을 진행합니다.
      loserMove(p2);
      // 이후 p1은 이긴 사람의 움직임을 진행합니다.
      move(p1, pos);
    }
    // p2가 이긴 경우
    else {
      // p2는 포인트를 얻게 됩니다.
      points[num2] += (s2 + a2) - (s1 + a1);
      // p1은 진 사람의 움직임을 진행합니다.
      loserMove(p1);
      // 이후 p2는 이긴 사람의 움직임을 진행합니다.
      move(p2, pos);
    }
  }

  // 1라운드를 진행합니다.
  public static void simulate() {
    // 첫 번째 플레이어부터 순서대로 진행합니다.
    for (int i = 0; i < m; i++) {
      int num = players[i].num;
      int x = players[i].x;
      int y = players[i].y;
      int d = players[i].d;
      int s = players[i].s;
      int a = players[i].a;

      // Step 1-1. 현재 플레이어가 움직일 그 다음 위치와 방향을 구합니다.
      Tuple next = getNext(x, y, d);
      int nx = next.x, ny = next.y, ndir = next.dir;

      // 해당 위치에 있는 전 플레이어 정보를 얻어옵니다.
      Player nextPlayer = findPlayer(new Pair(nx, ny));

      // 현재 플레이어의 위치와 방향을 보정해줍니다.
      Player currPlayer = new Player(num, nx, ny, ndir, s, a);
      update(currPlayer);

      // Step 2. 해당 위치로 이동해봅니다.
      // Step 2-1. 해당 위치에 플레이어가 없다면 그대로 움직입니다.
      if (nextPlayer == EMPTY)
        move(currPlayer, new Pair(nx, ny));
      // Step 2-2. 해당 위치에 플레이어가 있다면 결투를 진행합니다.
      else
        duel(currPlayer, nextPlayer, new Pair(nx, ny));
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 입력:
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) {
        gun[i][j] = new ArrayList<>();

        int num = sc.nextInt();
        // 총이 놓여 있는 칸입니다.
        if (num != 0)
          gun[i][j].add(num);
      }

    // 플레이어 정보를 입력받습니다.
    for (int i = 0; i < m; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int d = sc.nextInt();
      int s = sc.nextInt();
      players[i] = new Player(i, x - 1, y - 1, d, s, 0);
    }

    // k번에 걸쳐 시뮬레이션을 진행합니다.
    while (k-- > 0)
      simulate();

    // 각 플레이어가 획득한 포인트를 출력합니다.
    for (int i = 0; i < m; i++)
      System.out.print(points[i] + " ");
  }
}
