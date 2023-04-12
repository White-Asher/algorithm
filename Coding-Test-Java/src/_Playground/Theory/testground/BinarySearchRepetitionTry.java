package _Playground.Theory.testground;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearchRepetitionTry {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = binarySearch(arr, target, 0, n-1);

    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
            // 찾고자 하는 값이 중앙값보다 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
            // 찾고자 하는 값이 중앙값보다 큰 경우 오른쪽 확인
            else start = mid + 1;
        }
        return - 1;
    }
}
