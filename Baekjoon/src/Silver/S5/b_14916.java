package Silver.S5;

/*
1. 최대한 많이 써야하는 greedy
2. dp로도 풀 수 있지만 구현으로 해결
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_14916 {

  static int totalMoney;
  static int result;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    totalMoney = Integer.parseInt(br.readLine());

    while (totalMoney > 0) {
      if (totalMoney % 5 == 0) {
        result += totalMoney / 5;
        break;
      }
      totalMoney -= 2;
      result++;
    }

    if (totalMoney < 0) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }
  }
}
