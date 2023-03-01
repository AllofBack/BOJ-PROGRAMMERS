package LEVEL0;

public class P_120923 {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        int nSum = num * (num + 1) / 2;
        int start = (total - nSum) / num;

        for(int i = 1; i < num + 1; i++) {
            answer[i - 1] = i + start;
        }

        return answer;
    }
}
