package BOJ.Greedy.BOJ_1132_G3_합;

import java.util.*;
import java.io.*;

public class BOJ_1132_G3_합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            sb.append(input).append(" ");
        }

        String[] inputArr = sb.toString().split(" ");
        Map<Character, Long> map = new HashMap<>();
        Map<Character, Boolean> check = new HashMap<>();
        Set<Character> nonZero = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String input = inputArr[i];
            for (int j = 0; j < input.length(); j++) {
                char target = input.charAt(j);
                long value = (long) Math.pow(10, input.length() - 1 - j);
                map.put(target, map.getOrDefault(target, 0L) + value);
                check.put(target, false);
            }
            nonZero.add(input.charAt(0));
        }
        max = check.size();

        List<Map.Entry<Character, Long>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> Long.compare(o1.getValue(), o2.getValue()));

        long ans = 0L;
        long val = 10 - max;
        boolean flag = true;
        if(val == 0) {
            for (Map.Entry<Character, Long> characterIntegerEntry : entryList) {
                // 0이 들어오면 안되는 수 체크 -> 들어오면 안되는 수면 해당 수 건너뜀
                if(nonZero.contains(characterIntegerEntry.getKey()) && flag) continue;
                if(!flag) break;
                flag = false;
                check.put(characterIntegerEntry.getKey(), true);
                val+= 1;
            }

        }


        for (Map.Entry<Character, Long> characterIntegerEntry : entryList) {
            // 0부터 할당하는데 이미 할당한 애면.. 건너뛴다.
            if(check.get(characterIntegerEntry.getKey())) continue;
            ans += (characterIntegerEntry.getValue() * val);
            check.put(characterIntegerEntry.getKey(), true);
            val+= 1;
        }

        System.out.println(ans);

    }
}
