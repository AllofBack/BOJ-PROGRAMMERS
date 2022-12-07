package Silver.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_2217 {

    static int n;
    static int max;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, array[i] * (n-i));
        }

        System.out.println(max);
    }

}