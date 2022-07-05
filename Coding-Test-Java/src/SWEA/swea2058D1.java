// SWEA-2058[D1] 자릿수 더하기

package SWEA;

import java.util.Scanner;

public class swea2058D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        while (n>=10){
            result += (n%10);
            n /= 10;
        }
        result += n;
        System.out.println(result);
    }
}
