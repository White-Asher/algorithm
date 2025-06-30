package BOJ.Bruteforce.BOJ_2548_S3_대표자연수;

import java.util.*;
import java.io.*;

public class BOJ_2548_S3_대표자연수_250629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int minVal = 0;

        int target = arr[ (N-1) / 2];
        int temp = 0;
        for (int j = 0; j < N; j++) {
            temp += Math.abs(target - arr[j]);
        }
        if(temp < min) {
            min = temp;
            minVal = target;
        }


        System.out.println(minVal);
    }

}
