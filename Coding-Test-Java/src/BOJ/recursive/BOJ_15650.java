package BOJ.recursive;

import java.util.Scanner;

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 고른 수열은 오름차순이어야 한다.
public class BOJ_15650 {
	static int N, M;
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		permutation(0, 1);
	}
	
	public static void permutation(int cnt, int start) {
		if(cnt == M) {
			for (int i : nums) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i <= N; i++) {
			nums[cnt] = i;
			permutation(cnt+1, i+1);
		}
	}
}