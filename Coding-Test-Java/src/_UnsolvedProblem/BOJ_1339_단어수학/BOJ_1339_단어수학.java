package _UnsolvedProblem.BOJ_1339_단어수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339_단어수학 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[26];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int temp = (int) Math.pow(10, input.length() - 1);
            for (int j = 0; j < input.length(); j++) {
                arr[(int) input.charAt(j) - 65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(arr);
        int num = 9;
        int ans = 0;
        for (int i = arr.length -1; i >= arr.length - 10; i--) {
            ans += arr[i] * num--;
        }

        System.out.println(ans);
    }
}
