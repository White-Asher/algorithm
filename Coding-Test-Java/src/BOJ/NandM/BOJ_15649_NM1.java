package BOJ.NandM;

import java.util.Scanner;

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
public class BOJ_15649_NM1 {
	static int N, M;
	static int[] nums;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		check = new boolean[N+1];
		permutation(0);
	}
	
	public static void permutation(int cnt) {
		if(cnt == M) {
			for (int i : nums) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(check[i]) continue;
			nums[cnt] = i;
			check[i] = true;
			permutation(cnt+1);
			check[i] = false;
		}
	}
}
