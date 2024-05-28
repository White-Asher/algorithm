package BOJ.String.BOJ_20310_S3_타노스;

import java.io.*;

public class BOJ_20310_S3_타노스 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split("");
        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if(Integer.parseInt(String.valueOf(input.charAt(i))) == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }
        zeroCnt/=2;
        oneCnt/=2;
        int z = 0;
        int o = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if(Integer.parseInt(String.valueOf(input.charAt(i))) == 0) {
                if(z >= zeroCnt){
                    arr[i] = "2";
                } else {
                    z++;
                }
            }
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            if(Integer.parseInt(String.valueOf(input.charAt(i))) == 1) {
                if(o >= oneCnt){
                    arr[i] = "2";
                } else {
                    o++;
                }
            }
        }

        for (String string : arr) {
            if(Integer.parseInt(string) != 2) {
                sb.append(string);
            }
        }
        System.out.println(sb);
    }
}
