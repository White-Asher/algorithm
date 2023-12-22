package _dummy.Codeup.ps80;

import java.util.Scanner;

public class Ps80 {
    public static void main(String[] args) {
        int sum = 0;
        int a = 0;

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        while(i > sum){
            a += 1;
            sum += a;
        }
        System.out.println(a);
    }
}
