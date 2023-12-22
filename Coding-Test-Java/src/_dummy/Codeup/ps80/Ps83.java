package _dummy.Codeup.ps80;

import java.util.Scanner;

public class Ps83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        for(int a = 1; a <= i; a++){
            if(a%3 ==0){
                System.out.print("X ");
            }
            else{
                System.out.print(a+" ");
            }
        }
    }
}
