package week2;

/*
- 압축된 문자열 풀기
- 3{ab} -> ababab
- f2{abcbcbc}z -> fabcbcbcabcbcbcz
 */

public class Solution03 {

    int i = 0; // 현 인덱스

    public String solution(String code) {
        return recursive(code);
    }

    public String recursive(String code) {
        StringBuilder sb= new StringBuilder();
        String temp;

        int num = 0;

        while(i < code.length()) {
            if (Character.isDigit(code.charAt(i))) { // 숫자일 경우
                num = Character.getNumericValue(code.charAt(i));
                i++;
            } else if(code.charAt(i) == '{') {
                i++;
                temp = recursive(code);
                sb.append(temp.repeat(num)); // repeat 메서드 활용
            } else if (code.charAt(i) == '}') {
                i++;
                break;
            }
            else {
                sb.append(code.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
