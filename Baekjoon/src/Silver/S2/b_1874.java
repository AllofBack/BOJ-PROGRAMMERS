package Silver.S2;

/*
[MY TIL]
1. 스택 LIFO 구조
2. 다음 push를 위해 현 start에 value 값으로 바꿔주는게 중요
3. 예외 상황 & no를 출력하는 상황이 어떤때인지 확인
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        int start = 0;

        while(N -- > 0) {

            int value = Integer.parseInt(br.readLine());

            if(value > start) {
                for(int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = value;
            }
            // top에 있는 원소가 입력받은 값과 같이 않은 경우
            else if(stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');

        }
        System.out.println(sb);

        /* 더 효율적인 방법

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		boolean flag=true;
		//우선 입력
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack=new Stack<>();
		int cnt=0;

		for(int i=0;i<n;i++) {
			if(arr[i]<cnt) {
				if(stack.peek()==arr[i]) {
					stack.pop();
					sb.append("-"+"\n");
				}else {
					flag=false;
					break;
				}
			}else {
				while(cnt<arr[i]) {
					stack.add(++cnt);
					sb.append("+"+"\n");
				}
				stack.pop();
				sb.append("-"+"\n");
			}
		}
		if(flag)
			System.out.println(sb);
		else
			System.out.println("NO");
	}
        */

    }
}
