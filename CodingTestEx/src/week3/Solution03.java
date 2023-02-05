package week3;

public class Solution03 {
    static  int i = 0;
    public String solution(String code) {
        return recursive(code);
    }

    public String recursive(String code) {

        StringBuilder sb = new StringBuilder();
        String temp;

        int num = 0;

        while(i < code.length()) {
            if (Character.isDigit(code.charAt(i))) {
                num = Character.getNumericValue(code.charAt(i));
                i++;
            } else if(code.charAt(i) == '{') {
                i++;
                temp = recursive(code);
                sb.append(temp.repeat(num));
            } else if (code.charAt(i) == '}') {
                i++;
                break;
            } else {
                sb.append(code.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
