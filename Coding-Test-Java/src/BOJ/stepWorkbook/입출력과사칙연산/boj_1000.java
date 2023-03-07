package BOJ.stepWorkbook.입출력과사칙연산;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a+b);
    }
}
/* 기본방법
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();

		System.out.println(A+B);

		in.close();
	}
}
 */
