package BOJ.Greedy.BOJ_1083_G4_소트;

import java.util.*;
import java.io.*;

public class BOJ_1083_G4_소트_250618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine());
        int targetIdx = 0;
        int searchIdx = 0;
        int max = 0;

        while(s > 0) {
            if(targetIdx > N - 1) break;
            boolean check = false;
            max = arr[targetIdx];
            for(int i = targetIdx; i <= s + targetIdx; i++) {

                if(i < N && arr[i] > max) {
                    max = arr[i];
                    searchIdx = i;
                    check = true;
                }
            }
            if(check) {
                // 버블링 구현
                for(int i = searchIdx; i > targetIdx; i--){
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
                s -= searchIdx - targetIdx;
            }
            targetIdx++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
