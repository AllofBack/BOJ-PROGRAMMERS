package Silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
- 전위 순회 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
- 중위 순회 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
- 후위 순회 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
*/
public class b_1991 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // Initialize
        Node[] arr = new Node[N];
        char al = 'A';

        for (int i = 0; i < N; i++) {
            arr[i] = new Node(al++);
        }

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            arr[line[0] - 65].left = line[2] == '.' ? null : arr[line[2] - 65];
            arr[line[0] - 65].right = line[4] == '.' ? null : arr[line[4] - 65];
        }

        System.out.println(preorder(arr[0]));
        System.out.println(inorder(arr[0]));
        System.out.println(postorder(arr[0]));
    }

    private static String preorder(Node node) {
        String retVal = "";
        retVal += node.self;
        if (node.left != null) retVal += preorder(node.left);
        if (node.right != null) retVal += preorder(node.right);
        return retVal;
    }

    private static String inorder(Node node) {
        String retVal = "";
        if (node.left != null) retVal += preorder(node.left);
        retVal += node.self;
        if (node.right != null) retVal += preorder(node.right);
        return retVal;
    }

    private static String postorder(Node node) {
        String retVal = "";
        if (node.left != null) retVal += preorder(node.left);
        if (node.right != null) retVal += preorder(node.right);
        retVal += node.self;
        return retVal;
    }

    private static class Node {
        char self;
        Node left, right;

        public Node(char self) {
            this.self = self;
        }

        public String toString() {
            return self + "";
        }
    }
}
