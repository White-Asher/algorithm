package Softeer.level2;

import java.util.*;
import java.io.*;


public class 회의실예약 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static void main(String args[]) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 회의실 정보 넣기
        Map<String, Integer[]> room = new HashMap<>();
        for(int n = 0; n < N; n++) {
            String roomName = br.readLine();
            Integer[] timeArr = new Integer[19];
            room.put(roomName, timeArr);
        }

        // 회의실 시간대 넣기
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            String bookRoom = String.valueOf(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
//            Integer[] getArr = room.get(bookRoom);
//            for(int index = startTime; index < endTime; index++){
//                getArr[index] = 1;
//            }
        }
//
//        // 시간대 확인해서 출력
//        for(int n = 0; n < N; n++) {
//
//        }



        System.out.println(0);
    }
}
