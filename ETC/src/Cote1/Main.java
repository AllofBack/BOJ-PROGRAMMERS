package Cote1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N명
        double probability = 1.0;

        int[] cards = new int[5]; // 무늬별 카드의 수
        for (int i = 0; i < 54; i++) {
            cards[i / 13]++;
        }

        for (int i = 0; i < 5; i++) {
            probability *= combination(cards[i], N);
        }

        System.out.println(probability / combination(54, N));
    }

    // 조합 계산 함수
    public static double combination(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        } else {
            return combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }
}
