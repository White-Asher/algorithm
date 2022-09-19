package Theory.SJB;

import java.util.Scanner;

public class SubSetBinaryCounting {
	static int[] nums;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
		subset();
	}
	
	public static void subset() {
		for (int flag = 0, caseCnt = 1 << 1; flag < caseCnt; flag++) {
			
			for (int i = 0; i < N; i++) {
				if((flag & 1 << i)!= 0) {
					System.out.println(nums[i] + " ");
				}
			}
			System.out.println();
		}
	}
}
