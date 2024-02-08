/*
제목 : 가장 긴 증가하는 부분수열2
알고리즘 유형 : #binarysearch
플랫폼 : #BOJ
난이도 : G2
문제번호 : 12015
시간 : INF
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/12015
특이사항 : #
*/

package BOJ.BinarySearch.BOJ_12015_G2_가장긴증가하는부분수열2;

import java.util.*;
import java.io.*;

public class BOJ_12015_G2_가장긴증가하는부분수열2 {
    static int N;
    static int[] arr;
    static int[] LIS;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; // 수열 (입력값)
        LIS = new int[N]; // 가장 큰 수열 저장 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        int lengthLIS = 1;

        // 배열 전부 탐색
        for (int i = 1; i < N; i++) {
            int current = arr[i];

            // 다음 탐색 숫자가 현재 저장된 가장 큰 수열보다 크다면 뒤에 삽입
            if(LIS[lengthLIS - 1] < current) {
                LIS[lengthLIS] = current;
                lengthLIS++;
            }

            else {
                int left = 0;
                int right = lengthLIS;

                while(left < right) {
                    int mid = (left + right) / 2;
                    if(LIS[mid] < current) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                LIS[left] = current;
            }
        }
        System.out.println(lengthLIS);
    }
}
