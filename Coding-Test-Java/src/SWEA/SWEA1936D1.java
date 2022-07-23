// SWEA-1936[D1] 1대1 가위바위보

package SWEA;

import java.util.Scanner;

public class SWEA1936D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a == 1 & b == 2){
            System.out.println("B");
        } else if (a == 1 & b== 3) {
            System.out.println("A");
        } else if (a == 2 & b == 3) {
            System.out.println("B");
        } else if (a == 2 & b == 1){
            System.out.println("A");
        } else if (a == 3 & b == 1) {
            System.out.println("B");
        } else if (a == 3 & b == 2) {
            System.out.println("A");
        }
    }
}
