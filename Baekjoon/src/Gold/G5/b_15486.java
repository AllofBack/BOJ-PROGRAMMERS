package Gold.G5;

/*
- DP 문제 : Dynamic Programming
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_15486 {
    static int day;
    static int[] time;
    static int[] pay;
    static int[] dp;
    static int result;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        day = Integer.parseInt(br.readLine());
        
        time = new int[day + 1];
        pay = new int[day + 1];
        
        for (int i = 0; i < day; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[day + 1];
        result = Integer.MIN_VALUE;

        for (int i = 0; i <= day; i++) {
            result = Math.max(result, dp[i]);

            int next = i + time[i];
            if (next <= day) {
                dp[next] = Math.max(dp[next], result + pay[i]);
            }
        }
        System.out.println(result);
    }
}
