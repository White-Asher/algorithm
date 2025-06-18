package BOJ.Greedy.BOJ_1461_G4_도서관;

import java.io.*;
import java.util.*;

public class BOJ_1461_G4_도서관_250617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] sarr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sarr[i]);
        }
        Arrays.sort(arr);

        int ans = 0;
        int max = 0;

        int idx = 0;
        while(idx < N && arr[idx] < 0) {
            max = Math.max(Math.abs(arr[idx]), max);
            ans += Math.abs(arr[idx])*2;
            idx+=M;
            if(idx >= N) break;
            if(arr[idx] > 0) break;
        }

        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Comparator.reverseOrder());
        idx = 0;

        while(idx < N && arr2[idx] > 0) {
            max = Math.max(Math.abs(arr2[idx]), max);
            ans += Math.abs(arr2[idx])*2;
            idx+=M;
            if(idx >= N) break;
            if (arr2[idx] < 0) break;
        }

        System.out.println(ans -= max);
    }
}