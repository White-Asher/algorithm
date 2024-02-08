package _UnderstandNOT.BOJ_17387_G2_선분교차2;

import java.io.*;
import java.util.*;


// CCW 알고리즘 참고 : https://nahwasa.com/entry/CCW%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%84%A0%EB%B6%84-%EA%B5%90%EC%B0%A8-%ED%8C%90%EC%A0%95

public class BOJ_17387_G2_선분교차2 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 선분1
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        // 선분2
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        System.out.println(isCross(x1, y1, x2, y2, x3, y3, x4, y4) ? 1 : 0);
    }

    private static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        // x1, y1 -> a, x2, y2 -> b, x3, y3 -> c, x4, y4 -> d
        int abc = CCW(x1, y1, x2, y2, x3, y3);
        int abd = CCW(x1, y1, x2, y2, x4, y4);
        int cda = CCW(x3, y3, x4, y4, x1, y1);
        int cdb = CCW(x3, y3, x4, y4, x2, y2);
        // 만약 A, B 선분이 평행하다면 서로 겹치는 구간이 있는지 판별해야한다.
        if (abc * abd == 0 && cda * cdb == 0) {
            return isStack(x1, y1, x2, y2, x3, y3, x4, y4);
        }
        // 만약 두 선분이 0보다 작으면 서로 만나는 교차하는 구간이 있음.
        else if (abc * abd <= 0 && cda * cdb <= 0) {
            return true;
        }
        return false;
    }

    /*
    CCW 알고리즘
    벡터 A X B 의 값 D가
    D > 0 이면 A를 기준으로 B는 반시계 방향
    D = 0 이면 A, B 가 어느 한 선분 위에 만나는 경우
    D < 0 이면 A를 기준으로 B는 시계방향
     */
    static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long vector = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * + y2 + x1 *y3);
        if(vector > 0) return 1;
        else if(vector < 0) return -1;
        return 0;
    }

    // 평행한 두 선분이 겹치는지 파악하기.
    private static boolean isStack(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        if( Math.min(x1,  x2) <= Math.max(x3,  x4) &&
            Math.min(x3,  x4) <= Math.max(x1,  x2) &&
            Math.min(y1,  y2) <= Math.max(y3,  y4) &&
            Math.min(y3,  y4) <= Math.max(y1,  y2)
        ) return true;
        else return false;
    }
}
