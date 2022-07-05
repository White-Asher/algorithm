// SWEA-1945[D2] 간단한 소인수 분해

package SWEA;

import java.util.Scanner;

public class swea1945D2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int[] primeFactor = {2,3,5,7,11};
            int[] result = {0,0,0,0,0};
            int num = scanner.nextInt();

            while(true){
                if(num == 1){
                    break;
                }

                for (int j = 0; j < primeFactor.length; j++) {
                    if(num % primeFactor[j] == 0){
                        result[j] += 1;
                        num = num / primeFactor[j];
                    }
                }
            }

            System.out.print("#" +(i+1)+" ");
            for (int k = 0; k < primeFactor.length; k++) {
                System.out.print(result[k]+" ");
            }
            System.out.println();
        }
    }
}
