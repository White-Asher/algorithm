package _UnsolvedProblem.BOJ_6987_월드컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            boolean check = true;
            st = new StringTokenizer(br.readLine());

            int[] a = new int[6];
            int[] b = new int[6];
            int[] c = new int[6];

            int idx1 = 0;
            int idx2 = 0;
            int idx3 = 0;
            // 배열에 데이터 넣기
            for (int j = 0; j < 18; j++) {
                if(j % 3 == 0) {
                    a[idx1++] = Integer.parseInt(st.nextToken());
                } else if (j % 3 == 1) {
                    b[idx2++] = Integer.parseInt(st.nextToken());
                } else if (j % 3 == 2){
                    c[idx3++] = Integer.parseInt(st.nextToken());
                }
            }

            int win = 0;
            int lose = 0;
            boolean winCheck = false;
            boolean loseCheck = false;
            boolean winleast = false;
            boolean loseleast = false;

            for (int j = 0; j < 6; j++) {
                win += a[j];
                lose += c[j];
                if ((a[j] + b[j] + c[j]) !=5) {
                    check = false;
                }
                if(a[j] == 5) {
                    winCheck = true;
                } else if (c[j] == 0) {
                    winleast = true;
                }
                if(c[j] == 5) {
                    loseCheck = true;
                } else if (a[j] == 0){
                    loseleast = true;
                }
            }

            if((winCheck && winleast) || loseCheck && loseleast) {
                check = false;
            }

            if(win != lose) {
                check = false;
            }

            int temp = 0;
            for (int j = 0; j < 6; j++) {
                if(temp == 0) {
                    temp += b[j];
                } else if (temp > 0) {
                    temp -= b[j];
                } else {
                    temp += b[i];
                }
            }

            if(temp != 0) {
                check = false;
            }
            sb.append(check ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}
