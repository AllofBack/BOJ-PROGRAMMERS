package Silver.S4;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class b_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());	// 정수 입력

            if(number == 0) {	// 0이라면 스택에 저장된 top 원소를 지운다.
                stack.pop();
            }
            else {
                stack.push(number);
            }
        }
        int sum = 0;

        for(int o : stack) {
            sum += o;
        }

        System.out.println(sum);
    }
}