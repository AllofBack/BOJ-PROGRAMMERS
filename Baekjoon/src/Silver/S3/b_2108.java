package Silver.S3;

/*
[MY TIL]
1. 최빈값 구하기가 까다로운 부분
2. HashMap key, value 사용해서 해결하기
3. 최빈값이 2개 이상일 경우 2번째로 작은 값을 뽑아내야하기 때문에 추가 코드 필요
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class b_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int loop = Integer.parseInt(br.readLine());
        double sum = 0;
        for (int i = 0; i < loop; i++) {
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            list.add(temp);
        }

        // 중앙값 찾기 위해 미리 정렬
        Collections.sort(list);

        int max = Collections.max(list);
        int min = Collections.min(list);

        if (max < 0 && min < 0) {
            min = Math.abs(min);
        } else if( max > 0 && min > 0) {
            min = min * -1;
        } else { // 서로 부호 다를 때, 둘 중 하나라도 0일 때
            max = Math.abs(max);
            min = Math.abs(min);
        }

        double dle = sum / loop;
        int Average = (int) Math.round(dle);
        int Median = list.get(loop/2);
        int Mode = 0;
        int Range = min + max;

        for (int num : list) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int numbers = 0;
        for (int key : hashMap.values()) {
            numbers = Math.max(numbers, key);
        }
        list.clear();
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) == numbers) {
                list.add(key);
            }
        }

        Collections.sort(list);

        if (list.size() >= 2) {
            Mode = list.get(1);
        } else {
            Mode = list.get(0);
        }

        System.out.println(Average);
        System.out.println(Median);
        System.out.println(Mode);
        System.out.println(Range);
    }
}
