package Silver.S1;

import java.util.*;

public class b_14675 {
    static ArrayList<Integer>[] list;
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        list = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            list[n1].add(n2);
            list[n2].add(n1);
        }

        int q = scan.nextInt();
        for(int i = 0; i < q; i++) {
            int t = scan.nextInt();
            int k = scan.nextInt();

            if(t == 2) System.out.println("yes");
            else {
                int count = 0;
                for(int temp : list[k]) {
                    count++;
                }
                if(count >= 2) System.out.println("yes");
                else System.out.println("no");
            }
        }
    }
}
