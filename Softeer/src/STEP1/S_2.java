package STEP1;

import java.util.*;
import java.io.*;

public class S_2
{
    static int N;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            System.out.println("Case #" + i + ": " + result);
        }
    }
}