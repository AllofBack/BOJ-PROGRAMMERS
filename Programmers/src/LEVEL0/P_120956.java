package LEVEL0;

public class P_120956 {

    static String[] says = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;
        StringBuilder blank = new StringBuilder();

        for (String word : babbling) {
            for (String say : says) {
                if (word.contains(say)) {
                    word = word.replace(say, " ");
                    blank.append(" ");
                }

                if (word.equals(blank.toString())) {
                    answer++;
                    break;
                }
            }
            blank.setLength(0);
        }
        return answer;
    }
}