// note
import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // 메일을 받은 횟수
        HashMap<String, Integer> userMap = new HashMap<>(); // 유저 순서저장
        HashMap<String, HashSet<String>> reportMap = new HashMap<>(); // 각 유저별 자신을 신고한 유저 HashMap안에 Set을 value로 지정
        for(int i = 0; i < id_list.length; i++){
            userMap.put(id_list[i], i);
            reportMap.put(id_list[i], new HashSet<>());
        }
        
        // 자신을 신고한 유저 저장
        for(String s : report){
            String[] str = s.split(" ");
            reportMap.get(str[1]).add(str[0]);
        }
        
        // 유저별 신고당한 횟수가 K보다 많으면 메일 발송
        for(int i = 0; i < id_list.length; i++) {
            HashSet<String> set = reportMap.get(id_list[i]);
            if(set.size() >= k) {
                for(String userId : set) {
                    answer[userMap.get(userId)]++;
                }
            }
            
        }
        
        return answer;
    }
}

/* 실패한 풀이 */
// import java.util.*;
// import java.io.*;

// class Solution {
//     public int[] solution(String[] id_list, String[] report, int k) {
//         // [START] 신고한 사람 중복없이 저장하기
//         // 누가 신고했는지 저장한 HashSet
//         Map<String, HashSet<String>> reportId = new HashMap<>();
//         // 누구를 신고했는지 저장한 HashSet
//         Map<String, HashSet<String>> reportSave = new HashMap<>();
        
//         for(int i = 0; i < id_list.length; i++ ){
//             HashSet<String> newSet = new HashSet<>();
//             reportId.put(id_list[i], newSet);
//             HashSet<String> newSet2 = new HashSet<>();
//             reportSave.put(id_list[i], newSet2);
//         }
//         // 신고당한 사람 인덱스 맵
//         Map<String, Integer> idIndexMap = new HashMap<>();
        
//         // report배열 돌면서 누가 신고했는지 저장하기 (신고한사람, 신고당한사람)
//         for (int i = 0; i < report.length; i++) { 
//             String[] str = report[i].split(" ");
//             HashSet<String> getSet = reportId.get(str[1]);
//             getSet.add(str[0]);
//             reportId.put(str[1], getSet);
//             HashSet<String> getSet2 = reportSave.get(str[0]);
//             reportSave.put(str[0], getSet2);
//         }
            
//         // 신고결과 (대상, 신고한사람)
//         Iterator<String> keys = reportId.keySet().iterator();
//         while(keys.hasNext()){
//         	String key = keys.next();
//             System.out.println(key +" " + reportId.get(key));
//             idIndexMap.put(key, reportId.get(key).size());
//         }
        
//         Iterator<String> keys2 = idIndexMap.keySet().iterator();
//         while(keys2.hasNext()){
//         	String key = keys2.next();
//             System.out.println(key +" " + idIndexMap.get(key));
//         }
        
//         Iterator<String> keys3 = reportSave.keySet().iterator();
//         while(keys3.hasNext()){
//         	String key = keys3.next();
//             System.out.println(key +" " + reportSave.get(key));
//         }
        
        
//         // 정지 메일 보내기
//         for (int i = 0; i < id_list.length; i++) {
//             Set<String> getReportIdSet = reportId.get(id_list[i]);
//         }
//         // 신고한 사람의 처리 결과 배열
//         int[] answer = new int[id_list.length];

//         return answer;
//     }
// }