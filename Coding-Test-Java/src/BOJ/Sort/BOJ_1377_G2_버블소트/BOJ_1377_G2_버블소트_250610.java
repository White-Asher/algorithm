

package BOJ.Sort.BOJ_1377_G2_버블소트;

import java.util.*;
import java.io.*;

public class BOJ_1377_G2_버블소트_250610 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BubbleNumber[] arr = new BubbleNumber[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new BubbleNumber(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr, (o1, o2) -> o1.value - o2.value);

        int maxShift = 0;
        for (int i = 0; i < N; i++) {
            int curShift = arr[i].index - i;
            maxShift = Math.max(maxShift, curShift);
        }

        System.out.println(maxShift + 1);
    }

    static class BubbleNumber{
        int value;
        int index;

        public BubbleNumber(int _value, int _index){
            value = _value;
            index = _index;
        }
    }


}
/*
원래 인덱스: 처음 자리
정렬 후 인덱스: 순서대로 정렬한 뒤 자리
원래 인덱스 - 정렬 후 인덱스 = 왼쪽으로 총 몇 칸을 가야 하는지 (움직인 횟수임)

(시간초과)
기존 버블sorting 하면 시간초과 발생함 O(N^2) 이기 때문임.
또는 원본리스트, sorting할 배열을 선언해서 비교해도 똑같이 O(N^2)라 시간초과 발생함.
 */
