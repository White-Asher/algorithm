package Programers.lv2.주차요금계산;

import java.util.*;
import java.io.*;
public class Programmers_L2_주차요금계산 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans1 = solution.solution(
                new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                        "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                        "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        System.out.println(Arrays.toString(ans1));
        int[] ans2 = solution.solution(
                new int[]{120, 0, 60, 591},
                new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"});
        System.out.println(Arrays.toString(ans2));
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int dTime = fees[0];
        int dCharge = fees[1];
        int cTime = fees[2];
        int cCharge = fees[3];

        Map<String, Integer> carTime = new TreeMap<>();
        boolean[] check = new boolean[records.length];

        for(int i = 0; i < records.length; i++) {
            String[] str = records[i].split(" ");

            // OUT이라면 이전에 동일한 번호가 있으니 탐색합니다.
            if(str[2].equals("OUT")) {
                for(int e = 0; e <= i; e++){

                    String[] tStr = records[e].split(" ");

                    // 동일한 번호를 찾았다면 요금을 계산하고 리스트에 넣습니다.
                    if(tStr[1].equals(str[1]) && !check[e] && !check[i]) {
                        check[e] = true;
                        check[i] = true;
                        String[] seperateStr = str[0].split(":");
                        String[] separateTStr = tStr[0].split(":");

                        int oT = Integer.parseInt(seperateStr[0]); // out 시간
                        int oM = Integer.parseInt(seperateStr[1]); // out 분
                        int iT = Integer.parseInt(separateTStr[0]);// in 시간
                        int iM = Integer.parseInt(separateTStr[1]);// in 분

                        int totalT = oT - iT;
                        int totalM = oM - iM;
                        if(oM - iM < 0) {
                            totalM = 60 - (iM - oM);
                            totalT--;
                        }

                        int totalTM = totalT * 60 + totalM;
                        if((carTime.containsKey(tStr[1]))) {
                            int curTime = carTime.get(tStr[1]);
                            carTime.put(tStr[1], curTime + totalTM);
                        } else {
                            carTime.put(tStr[1], totalTM);
                        }

                        break;
                    }
                }
            }

        }

        // check가 flase면 23:59에 나간거로 생각해야함. 기존 시간 더하기
        for(int i = 0; i < records.length; i++) {
            if(check[i]) continue;
            String[] str = records[i].split(" ");
            String[] seperateStr = str[0].split(":");

            int oT = Integer.parseInt(seperateStr[0]);
            int oM = Integer.parseInt(seperateStr[1]);

            int totalT = 23 - oT;
            int totalM = 59 - oM;
            int totalTM = totalT * 60 + totalM;

            if((carTime.containsKey(str[1]))) {
                int getCharge = carTime.get(str[1]);
                carTime.put(str[1], getCharge + totalTM);
            } else {
                carTime.put(str[1], totalTM);
            }

        }

        // 요금 계산하기
        int[] ans = new int[carTime.size()];
        int idx = 0;
        for (String k : carTime.keySet()) {
            int totalTM = carTime.get(k);
            totalTM -= dTime;
            int totalCharge = dCharge;
            if(totalTM > 0){
                totalCharge+= Math.ceil( (float) totalTM/cTime) * cCharge;
            }
            ans[idx++] = totalCharge;

        }

        return ans;
    }
}
