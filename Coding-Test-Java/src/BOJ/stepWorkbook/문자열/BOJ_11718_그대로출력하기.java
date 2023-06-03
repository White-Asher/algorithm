package BOJ.stepWorkbook.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11718_그대로출력하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while( (str = br.readLine()) != null) {
            System.out.println(str);
        }
    }
}
