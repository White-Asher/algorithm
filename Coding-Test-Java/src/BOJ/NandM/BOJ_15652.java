package BOJ.NandM;

import java.util.Scanner;

public class BOJ_15652 {
	static int N, R;
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		
	}
	
	public static void duplicatePermutation(int cnt) {
		if(cnt == R) {
			
		}
		for(int i = 0; i <= N; i++) {
			nums[cnt] = i;
			duplicatePermutation(cnt+1);
		}
	}
}
