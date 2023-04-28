package _OnlineContest.agcu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        int cnt = 2;
        long num = 0;
        if (N == 0) {
            cnt = 0;
        } else if (N == 1) {
            cnt = 1;
        } else {
            num = 2;
            while(num != N) {
                if(num*2 < N){
                    num *= 2;
                    cnt++;
                } else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
