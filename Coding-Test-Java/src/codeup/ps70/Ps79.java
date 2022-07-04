package codeup.ps70;

import java.util.Scanner;

public class Ps79 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char alpha = 'a';
        while(alpha != 'q'){
            alpha = sc.next().charAt(0);
            System.out.println(alpha);
        }
    }
}
