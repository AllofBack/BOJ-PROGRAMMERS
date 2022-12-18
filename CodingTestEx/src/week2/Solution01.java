package week2;

import java.util.Arrays;

public class Solution01 {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] + 1 != numbers[i + 1]) {
                return numbers[i] + 1;
            }
        }
        return -1;
    }
}
