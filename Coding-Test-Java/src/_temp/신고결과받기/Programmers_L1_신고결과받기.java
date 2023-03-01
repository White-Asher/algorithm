package _temp.신고결과받기;

import java.util.*;

public class Programmers_L1_신고결과받기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TC1
        System.out.println(Arrays.toString(
                solution.solution(
                        new String[]{"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                        2
                )));
        // TC2
        System.out.println(Arrays.toString(
                solution.solution(
                        new String[]{"con", "ryan"},
                        new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                        3
                )));
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한자
        Map<String, HashSet<String>> reportId = new HashMap<>();
        // 신고한 사람의 처리 결과 배열
        int[] answer = new int[id_list.length];
        // 신고한 사람의 처리 결과 카운트 배열 인덱스 맵을 만듦
        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0 ; i < id_list.length ; i++) {
            idIndexMap.put(id_list[i], i);
        }

        // report배열 돌면서 유저 정지 카운트 추가
        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            if (reportId.get(str[1]) == null) {
               HashSet<String> newSet = new HashSet<>();
               reportId.put(report[1], newSet);
            }
            HashSet<String> getSet = reportId.get(str[1]);
            getSet.add(str[0]);
            reportId.put(str[1], getSet);
        }
        
        // 정지 메일 보내기
        for (int i = 0; i < id_list.length; i++) {
            Set<String> getReportIdSet = reportId.get(id_list[i]);

        }


        return answer;
    }
}