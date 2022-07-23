// SWEA-1933[D1] 간단한 N의 약수

package SWEA;

import java.util.Scanner;

public class SWEA1933D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1 ; i <= n; i++) {
            if(n%i == 0){
                System.out.print(i+" ");
            }
        }
    }
}
