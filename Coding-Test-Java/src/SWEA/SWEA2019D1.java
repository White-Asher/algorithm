// SWEA-2019[D1] 더블더블

package SWEA;

import java.util.Scanner;

public class SWEA2019D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 1;
        System.out.print(result+" ");
        for (int i = 1; i <= n; i++) {
            result *= 2;
            System.out.print(result+" ");
        }
    }
}
