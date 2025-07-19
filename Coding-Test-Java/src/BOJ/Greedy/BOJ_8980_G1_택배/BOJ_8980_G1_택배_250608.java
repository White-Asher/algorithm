//package BOJ.Greedy.BOJ_8980_G1_택배;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class BOJ_8980_G1_택배_250608 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int C = Integer.parseInt(st.nextToken());
//        int V = Integer.parseInt(br.readLine());
//
//        List<Box> list = new ArrayList<>();
//        for (int i = 0; i < V; i++) {
//            st = new StringTokenizer(br.readLine());
//            list.add(new Box(Integer.parseInt(st.nextToken()),
//                    Integer.parseInt(st.nextToken()),
//                    Integer.parseInt(st.nextToken())));
//        }
//
//        Collections.sort(list, new Comparator<Box>() {
//            @Override
//            public int compare(Box o1, Box o2) {
//                if(o1.start == o2.start) {
//                    return o1.end - o2.end;
//                } else {
//                    return o1.start - o2.start;
//                }
//            }
//        });
//        int curValue = 0;
//        List<Box> curList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            // 현재 있는 곳에서 짐 내리기
//            for(int ii = 0; ii < curList.size(); ii++) {
//
//            }
//
//            // 짐 계속 싣기
//            curList.add(new Box());
//            // 짐이 꽉 찼거나, 더이상 싣을 짐이 없다면 다음 목표 가기.
//
//        }
//    }
//
//    static class Box {
//        int start;
//        int end;
//        int weight;
//
//        public Box(int _start, int _end, int _weight) {
//            start = _start;
//            end = _end;
//            weight = _weight;
//        }
//
//    }
//}
