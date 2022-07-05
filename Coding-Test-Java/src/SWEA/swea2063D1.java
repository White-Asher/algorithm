// SWEA-2063[D1] 중간값 찾기

package SWEA;

import java.util.*;

public class swea2063D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        System.out.println(a[n/2]);
    }
}
