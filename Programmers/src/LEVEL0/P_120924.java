package LEVEL0;

public class P_120924 {

    public int solution(int[] common) {
        int answer = 0;
        int len = common.length - 1;

        if((common[len] - common[len - 1]) == (common[1] - common[0])) {
            answer = common[len] + (common[len] - common[len - 1]);
        } else {
            answer = common[len] * (common[len] / common[len - 1]);
        }

        return answer;
    }
}
