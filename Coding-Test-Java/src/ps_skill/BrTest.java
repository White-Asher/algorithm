package ps_skill;

import java.util.*;
import java.io.*;

public class BrTest {
    public static void main(String[] args) throws Exception {
        BrTest brTest = new BrTest();
//        brTest.test01();
//        brTest.test02();
    }

    // 정수 입출력 => 입력: 3 / 출력: 3
    public void test01() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // 정수 n을 BufferedWriter에 넣어서 출력하게 되면 글자가 깨진다. (String형으로의 변환이 필요함!)
        // bw.write(n);
        bw.write(String.valueOf(n));
        bw.flush();
        bw.close();
    }

    // 공백을 기준으로 입력받고, 공백을 넣어서 출력하기 입력:123 456 / 출력: 123 456
    public void test02() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(a)+"\t");
        bw.flush();
        bw.write(String.valueOf(b));
        bw.flush();
        bw.close();
    }


}
