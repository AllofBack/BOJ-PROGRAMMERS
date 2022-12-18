package Tree;

/**
 * 종이를 반으로 접었을 때, 안으로 파인 부분 0, 볼록 튀어나온 부분 1
 * 종이를 N번 접었을 때 접힌 상태 출력하기
 * 노드마다 왼쪽 0, 오른쪽 1 생성
 * 포화이진트리 구성 -> 중위순회로 출력하기 inOrder
 */

public class Practice1 {
    public static void solution(int n) {
        int[] binaryTree = new int[(int)Math.pow(2, n)];

        binaryTree[0] = 0;
        for (int i = 0; i < (int) Math.pow(2, n - 1) - 1; i++) {
            binaryTree[i * 2 + 1] = 0; // 왼쪽
            binaryTree[i * 2 + 2] = 1; // 오른쪽
        }

        inOrder(binaryTree, 0);
        System.out.println();
    }

    public static void inOrder(int[] arr, int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < arr.length - 1) {
            inOrder(arr, left);
        }

        System.out.print(arr[idx] + " ");

        if (right < arr.length - 1) {
            inOrder(arr, right);
        }
    }

    public static void main(String[] args) {
        //Test Code
        solution(1);
        solution(2);
        solution(3);
    }
}
