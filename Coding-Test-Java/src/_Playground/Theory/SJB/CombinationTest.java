package _Playground.Theory.SJB;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {
	static int N, R, totalCnt;
	static int[] nums;
	static int[] inputs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		nums = new int[R];
		inputs = new int[N];
		
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		
		combination(0, 0);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for(int i = start; i< N; i++) {
			nums[cnt] = inputs[i];
			combination(cnt+1, i+1);
		}
	}
}
