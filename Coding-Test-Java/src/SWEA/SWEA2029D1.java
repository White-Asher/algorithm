// SWEA-2029[D1] 몫과 나머지 출력하기

package SWEA;

import java.util.Scanner;

public class SWEA2029D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.print("#"+tc+" "+a/b+" "+a%b);
            System.out.println();
        }
    }
}
