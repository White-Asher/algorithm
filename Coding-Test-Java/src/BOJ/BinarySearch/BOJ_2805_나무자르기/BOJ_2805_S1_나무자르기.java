/*
제목 : 나무 자르기
알고리즘 유형 : #binarysearch
플랫폼 : #BOJ
난이도 : S1
문제번호 : 2805
시간 : -
해결 : O
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/2805
특이사항 : #
*/

package BOJ.BinarySearch.BOJ_2805_나무자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_S1_나무자르기 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());

        long max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            long inputNum = Long.parseLong(st.nextToken());
            arr[i] = inputNum;
            max = Math.max(max, inputNum);
        }
        long min = 1;
        max += 1;

        while (min < max) {
            long mid = (min + max) / 2;
            long len = 0;

            for (int i = 0; i < N; i++) {
                if(arr[i] - mid > 0) {
                    len += arr[i] - mid;
                }
            }

            if(len >= M) {
                min = mid + 1;
            } else {
                max = mid;
            }

        }
        System.out.println(min - 1);
    }
}
