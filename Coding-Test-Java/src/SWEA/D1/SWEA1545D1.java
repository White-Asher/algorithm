// SWEA-1545[D1] 거꾸로 출력해 보아요

package SWEA.D1;

import java.util.Scanner;

public class SWEA1545D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = n; i >=0 ; i--) {
            System.out.print(i +" ");
        }
    }
}
