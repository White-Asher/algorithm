package BOJ.stepWorkbook.입출력과사칙연산;

import java.util.Scanner;

public class boj_2588 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();

        System.out.println(A*(B%10));
        System.out.println(A*(B%100/10));
        System.out.println(A*(B/100));
        System.out.println(A*B);
    }
}
