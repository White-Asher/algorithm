package Codeup.ps80;

import java.util.Scanner;

public class Ps85 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double i = sc.nextInt();
        double j = sc.nextInt();
        double k = sc.nextInt();
        double l = sc.nextInt();

        double result = ((i*j*k*l)/8/1024/1024);

        System.out.printf("%.1f MB",result);
    }
}
