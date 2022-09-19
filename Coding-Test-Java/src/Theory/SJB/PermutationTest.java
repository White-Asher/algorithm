package Theory.SJB;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest {
	static int N, R, totalCnt;
	static int[] nums;
	static int[] input;
	static boolean[] isSelect;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		nums = new int[R];
		input = new int[N];
		isSelect = new boolean[N+1];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0);
		
	}
	public static void permutation(int cnt) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for(int i = 0; i< N; i++) {
			if(isSelect[i]) continue;
			nums[cnt] = input[i];
			isSelect[i] = true;
			permutation(cnt+1);			
			isSelect[i] = false;
		}
	}
}
