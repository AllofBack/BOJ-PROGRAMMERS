package Silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_9934 {
    static int K;
    static ArrayList<Integer>[] answer;
    static int[] visit;
    static int idx = 0;
    static int nodeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        answer = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            answer[i] = new ArrayList<>();
        }

        nodeSize = (int) Math.pow(2, K) - 1;
        visit = new int[nodeSize];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < nodeSize; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }

        Node root = new Node(null, null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 0; i < K - 1; i++) {
            int queueSize = queue.size();

            for (int j = 0; j < queueSize; j++) {
                Node parent = queue.poll();

                Node child1 = new Node(null, null);
                Node child2 = new Node(null, null);
                parent.left = child1;
                parent.right = child2;

                queue.offer(child1);
                queue.offer(child2);
            }
        }

        inorder(root, 0);

        for (ArrayList<Integer> levelNodes : answer) {
            for (Integer levelNode : levelNodes) {
                System.out.print(levelNode+" ");
            }
            System.out.println();
        }
    }

    private static void inorder(Node node, int level) {

        if (node.left != null) {
            inorder(node.left, level+1);
        }

        node.num = visit[idx++];
        answer[level].add(node.num);

        if(node.right != null){
            inorder(node.right, level+1);
        }
    }
}

class Node {
    int num;
    Node left;
    Node right;

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}