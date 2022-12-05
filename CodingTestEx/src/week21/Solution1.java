package week21;

/*
1. 시작과 끝이 일치하는 경우, 구문 합쳐서 저장하기
2. 해시 테이블을 활용한 해싱 문제
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public String[] solution(String[] phrases) {
        // 키 - 앞 부분의 맨 마지막 단어, 뒷 부분의 맨 첫 단어
        Map<String, List<String>> heads = new HashMap<>();
        Map<String, List<String>> tails = new HashMap<>();

        for (String phrase : phrases) {
            String[] phraseSplit = phrase.split(" ");
            String h = phraseSplit[phraseSplit.length - 1]; // 맨 끝 단어
            String t = phraseSplit[0]; // 첫 단어

            if (!heads.containsKey(h)) {
                heads.put(h, new ArrayList<>());
            }

            if (!heads.containsKey(t)) {
                tails.put(t, new ArrayList<>());
            }

            heads.get(h).add(phrase);
            tails.get(t).add(phrase);
        }

        List<String> result = new ArrayList<>();
        for (String h : heads.keySet()) {
            for (String head : heads.get(h)) {
                // 앞부분의 마지막 단어와 일치하는 뒷부분 첫단어가 있을 경우 진행
                if (!tails.containsKey(h)) {
                    continue;
                }

                for (String tail : tails.get(h)) { // 첫 단어가 맨 끝 단어인 경우,
                    StringBuilder sb = new StringBuilder();
                    sb.append(head);

                    String[] tailSplit = tail.split(" ");
                    for (int i = 1; i < tailSplit.length; i++) {
                        sb.append(" ");
                        sb.append(tailSplit[i]);
                    }
                    result.add(sb.toString());
                }
            }
        }

        return result.stream().sorted().toArray(String[]::new);
    }
}
