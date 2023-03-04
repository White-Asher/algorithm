package Softeer.unsolve;

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
        Map<String, int[]> room = new TreeMap<>();
        for(int n = 0; n < N; n++) {
            String roomName = br.readLine();
            int[] timeArr = new int[19];
            room.put(roomName, timeArr);
        }

        // 회의실 시간대 넣기
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            String bookRoom = String.valueOf(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            int[] getArr = room.get(bookRoom);
            for(int index = startTime; index < endTime; index++){
                getArr[index] = 1;
            }
        }

//        Map<String, int[]> map = new TreeMap<>(room);

        // 시간대 확인해서 출력
        // 룸수
        int roomCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (String key : room.keySet()) {
            roomCnt++;
            String roomName = key;
            sb.append("Room ");
            sb.append(roomName);
            sb.append(":").append("\n");

            int aval = 0;
            int[] getArr = room.get(key);
//            System.out.println(roomName);
//            System.out.println(Arrays.toString(getArr));
            for(int i = 9; i <= 18; i++) {
                // 빈곳 개수 찾기

                if(getArr[i] == 0){
                    int j = i;
                    while(j < 18){
                        if(getArr[j] == 1) {
                            aval++;
                            break;
                        }
                        j++;

                        if(j == 17 && getArr[j] == 0) {
                            aval++;
                        }
                    }
                    i = j;
                }

            }


            // 빈곳 찾았는데 빈곳이 없으면..
            if(aval == 0) {
                sb.append("Not available\n");
            } else {
                // 빈 곳이 있다면
                sb.append(aval).append(" available:\n");

                for(int i = 9; i <= 18; i++) {
                    if(getArr[i] == 0){
                        int j = i;
                        while(j < 18){

                            if(getArr[j] == 1) {

                                if(i < 10){
                                    sb.append("0").append(i).append("-").append(j).append("\n");
                                } else {
                                    sb.append(i).append("-").append(j).append("\n");
                                }

                                break;
                            }
                            j++;
                            if(j == 17 && getArr[j] == 0) {
                                if(i < 10){
                                    sb.append("0").append(i).append("-").append(18).append("\n");
                                } else {
                                    sb.append(i).append("-").append(18).append("\n");
                                }
                            }
                        }
                        i = j;

                    }
                }
            }

            if(roomCnt != N) {
                sb.append("-----\n");
            }

        }
         System.out.println(sb.toString());
    }
}