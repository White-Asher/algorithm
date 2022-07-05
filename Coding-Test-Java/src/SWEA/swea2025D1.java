// SWEA-2025[D1] N줄덧셈

package SWEA;

import java.util.Scanner;

public class swea2025D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        System.out.println(result);
    }
}
