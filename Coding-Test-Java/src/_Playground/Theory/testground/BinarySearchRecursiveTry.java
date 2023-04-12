package _Playground.Theory.testground;

import java.util.*;
import java.io.*;

public class BinarySearchRecursiveTry {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = binarySearch(arr, target, 0, n-1);

        System.out.println( (result == -1 ) ? "원소가 존재하지 않습니다" :  result + 1);

    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;

        if (arr[mid] == target) return mid;
        // 찾고자 하는 값이 작은 경우에는 mid기준 왼쪽
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        // 찾고자 하는 값이 큰 경우에는 mid 기준 오른쪽
        else return binarySearch(arr, target,  mid + 1, end);

    }

}
