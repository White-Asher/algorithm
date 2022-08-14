// SWEA-2050[D1] 알파벳을 숫자로 변환

package SWEA.D1;

import java.util.Scanner;

public class SWEA2050D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String text = scanner.nextLine();
        int textLength = text.length();

        for (int i = 0; i < textLength; i++) {
            for (int j = 0; j < alpha.length(); j++) {
                if(text.charAt(i) == alpha.charAt(j)){
                    System.out.print(j+1 + " ");
                }
            }
        }
    }
}
