package Codeup.ps70;

import java.util.Scanner;

public class Ps78 {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        i = sc.nextInt();
        for(int a = 2; a<=i ; a+=2){
            sum += a;
        }
        System.out.println(sum);
    }
}
