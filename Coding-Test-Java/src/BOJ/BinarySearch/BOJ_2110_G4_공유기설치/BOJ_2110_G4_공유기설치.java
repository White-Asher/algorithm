/*
제목 : 공유기설치
알고리즘 유형 : #binarysearch
플랫폼 : #BOJ
난이도 : G4
문제번호 : 2110
시간 : INF
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/2110
특이사항 : #
*/

package BOJ.BinarySearch.BOJ_2110_G4_공유기설치;

import java.util.*;
import java.io.*;

public class BOJ_2110_G4_공유기설치 {
    static StringTokenizer st;
    static long[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }  

        Arrays.sort(arr);

        long left = 1; // 최소거리
        long right = arr[arr.length - 1] - arr[0] + 1; // 최대 거리

        while(left <= right) {
            // 거리
            long mid = (left + right) / 2;

            // 설치 가능한 개수가 C개에 못미치면 거리를 좁혀야 한다.
            if(isInstall(mid) < C) {
                right = mid - 1;
            }
            // 설치가 가능하다면 (C개보다 이상)
            else {
                left = mid + 1;
            }

        }
        System.out.println(left - 1);
    }

    public static int isInstall(long dist) {
        int count = 1;
        long lastInstall = arr[0];

        // 순회하면서
        for (int i = 1; i < arr.length; i++) {
            long locate = arr[i];

            // 다음 설치 위치가 이전 설치 위치보다 멀다면 (최소 설치거리를 만족한다면)
            if(locate - lastInstall >= dist) {
                count++;
                lastInstall = arr[i];
            }
        }
        return count;
    }
}
