package STEP1;

import java.util.*;
import java.io.*;

public class S_1
{
    static int a;
    static int b;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if(a > b) {
            System.out.println("A");
        } else if(a < b) {
            System.out.println("B");
        } else System.out.println("same");

    }
}
