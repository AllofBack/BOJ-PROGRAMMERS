package Silver.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class b_11508 {
    static int n;
    static Integer[] list;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new Integer[n];

        for (int i = 0; i < n; i++) {
           list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if(i % 3 == 2) continue;
            result += list[i];
        }

        System.out.println(result);
    }
}
