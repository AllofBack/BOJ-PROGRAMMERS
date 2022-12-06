package week21;

/*
- 재귀로 해결가능하지만, 우선 해결이 되는지 해결 여부만 확인하는 방식으로 진행. O(N)
 */
public class Solution2 {
    public boolean solution(String s, String t) {
        if (s.equals(t)) {
            return false;
        }

        int abs = Math.abs(s.length() - t.length());

        if (abs > 1) {
            return false;
        }

        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            // 다른 문자열 발견시 3가지 방법으로 확인
            if (s.charAt(i) != t.charAt(i)) {
                if (s.substring(i+1).equals(t.substring(i+1))) {
                    return true;
                }

                if (s.substring(i+1).equals(t.substring(i))) {
                    return true;
                }

                if (s.substring(i).equals(t.substring(i+1))) {
                    return true;
                }
                return false;
            }
        }

        // 마지막 문자가 제거되거나, 마지막에 문자가 추가된 경우
        if (abs == 1) {
            return true;
        }

        return false;
    }
}
