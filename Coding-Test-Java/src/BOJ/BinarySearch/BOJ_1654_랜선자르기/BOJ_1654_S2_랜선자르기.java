/*
제목 : 랜선자르기
알고리즘 유형 : #binarysearch
플랫폼 : #BOJ
난이도 : S2
문제번호 : 1654
시간 : -
해결 : O
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/1654
특이사항 : #
참고한곳 : https://sete3683.tistory.com/50
*/

package BOJ.BinarySearch.BOJ_1654_랜선자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BOJ_1654_S2_랜선자르기 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long maxNum = 0;
        long[] arr = new long[K];

        for (int i = 0; i < K; i++) {
            long inputNum = Long.parseLong(br.readLine());
            arr[i] = inputNum;
            maxNum = Math.max(maxNum, inputNum);
        }

        long left = 1;
        long right = ++maxNum;

        while(left < right) {
            long mid = (left + right) / (long) 2;

            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += arr[i]/mid;
            }

            if (cnt >= N) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left - 1);
    }
}
