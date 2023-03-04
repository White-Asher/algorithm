import java.util.*;
import java.io.*;


public class 전광판 {
    static StringTokenizer st;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] digit = {
                {1,1,1,1,1,0,1},
                {0,0,0,0,1,0,1},
                {1,0,1,1,1,1,0},
                {1,0,0,1,1,1,1},
                {0,1,0,0,1,1,1},
                {1,1,0,1,0,1,1},
                {1,1,1,1,0,1,1},
                {1,1,0,0,1,0,1},
                {1,1,1,1,1,1,1},
                {1,1,0,1,1,1,1}
        };

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            int ans = 0;

            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            // System.out.println(5-a.length());
            for(int i = 0; i < 5-a.length();i++){
                sb1.append("*");
            }
            for(int i = 0; i < 5-b.length();i++){
                sb2.append("*");
            }
            String sba = sb1.append(a).toString();
            String sbb = sb2.append(b).toString();

            // 숫자 비교
            for(int i = 0; i<5; i++) {
                // b가 문자라면..
                if(sba.charAt(i) =='*' && sbb.charAt(i) !='*') {
                    int ib = Integer.parseInt(String.valueOf(sbb.charAt(i)));
                    for(int d = 0; d < 7; d++) {
                        if(digit[ib][d] == 1){
                            ans++;
                        }
                    }
                }
                // a 문자
                else if (sba.charAt(i) !='*' && sbb.charAt(i) =='*') {
                    int ia = Integer.parseInt(String.valueOf(sba.charAt(i)));
                    for(int d = 0; d < 7; d++) {
                        if(digit[ia][d] == 1){
                            ans++;
                        }
                    }
                }

                // ab둘다 숫자
                else if (sba.charAt(i) !='*' && sbb.charAt(i) !='*') {
                    int ia = Integer.parseInt(String.valueOf(sba.charAt(i)));
                    int ib = Integer.parseInt(String.valueOf(sbb.charAt(i)));

                    for(int d = 0; d < 7; d++) {
                        if(digit[ib][d] != digit[ia][d]){
                            ans++;
                        }
                    }
                }
            }

            System.out.println(ans);
        }

    }
}