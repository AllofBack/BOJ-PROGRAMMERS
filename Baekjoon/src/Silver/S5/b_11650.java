package Silver.S5;

/*
[MY TIL]
1. 람다식이 아닌 Comparator로 구현시 아래와 같다.
Arrays.sort(arr, new Comparator<int[]>() {
	@Override
	public int compare(int[] e1, int[] e2) {
		if(e1[0] == e2[0]) {		// 첫번째 원소가 같다면 두 번째 원소끼리 비교
			return e1[1] - e2[1];
		}
		else {
			return e1[0] - e2[0];
		}
	}
});
*/

import java.util.Scanner;
import java.util.Arrays;

public class b_11650 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1[0] == e2[0]){
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for(int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
