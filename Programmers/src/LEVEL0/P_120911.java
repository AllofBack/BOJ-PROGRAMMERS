package LEVEL0;

import java.util.Arrays;

public class P_120911 {

    public String solution(String my_string) {
        my_string = my_string.toLowerCase();

        char[] list = my_string.toCharArray();
        Arrays.sort(list);

        String answer = "";
        answer = new String(list);

        return answer;
    }

}
