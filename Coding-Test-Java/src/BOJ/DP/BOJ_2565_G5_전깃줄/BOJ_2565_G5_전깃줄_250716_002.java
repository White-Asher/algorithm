package BOJ.DP.BOJ_2565_G5_전깃줄;

import java.io.*;
import java.util.*;

public class BOJ_2565_G5_전깃줄_250716_002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        List<Line> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                if(o1.a == o2.a) {
                    return o1.a - o2.b;
                }
                return o1.a - o2.a;
            }
        });

        // LIS 후보를 저장하는 리스트
        // lis.get(i)는 길이가 i+1인 증가 부분 수열의 마지막 원소 중 가장 작은 값을 의미
        List<Integer> lis = new ArrayList<>();
        lis.add(list.get(0).b);

        for (int i = 1; i < N; i++) {
            int num = list.get(i).b;

            // 현재 숫자가 lis의 마지막 값보다 크면,
            // LIS의 길이가 늘어나는 것이므로 리스트에 추가
            if(num > lis.get(lis.size() - 1)) {
                lis.add(num);
            } else {
                // 그렇지 않으면, lis 내에서 num이 들어갈 위치를 찾음.
                // (num보다 크거나 같은 첫 번째 원소의 위치)
                int position = Collections.binarySearch(lis, num);
                // 이진탐색후 못찾으면 음수 반환
                if(position < 0) {
                    int insertPosition = -(position + 1);
                    lis.set(insertPosition, num);
                }
            }
        }

        System.out.println(N - lis.size());
    }

    static class Line{
        int a;
        int b;

        public Line(int _a, int _b){
            a = _a;
            b = _b;
        }

    }
}


