package STEP2;

import java.util.*;
import java.io.*;

public class S_3
{
    public static int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
    public static int[] dsc = {8, 7, 6, 5, 4, 3, 2, 1};
    public static boolean comp(int[] arr1, int[] arr2) {
        for(int i = 0; i < 8; i++) if(arr1[i] != arr2[i]) return false;
        return true;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[8];
        for(int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(comp(asc, arr)) System.out.println("ascending");
        else if(comp(dsc, arr)) System.out.println("descending");
        else System.out.println("mixed");
    }
}