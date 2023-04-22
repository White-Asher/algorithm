package _UnsolvedProblem.BOJ_13144_ListofUniqueNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13144_ListofUniqueNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] cnt = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int ans = 0;

        while(left <= N){
            while(right < N && cnt[arr[right + 1]] == 0){
                right++;
                cnt[arr[right]]++;
            }
            ans += right - left + 1;
            cnt[arr[left++]]--;
        }
        System.out.println(ans);
    }

}
