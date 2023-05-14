package _Playground.Theory.SJB;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	static int N, R, totalCnt;
	static int[] nums, input;
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
		System.out.println("totalCnt : " + totalCnt);
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
			permutation(cnt + 1);
			isSelect[i] = false;
		}
	}
}

/*
input
5 3
1 2 3 4 5

output
[1, 2, 3]
[1, 2, 4]
[1, 2, 5]
[1, 3, 2]
[1, 3, 4]
[1, 3, 5]
[1, 4, 2]
[1, 4, 3]
[1, 4, 5]
[1, 5, 2]
[1, 5, 3]
[1, 5, 4]
[2, 1, 3]
[2, 1, 4]
[2, 1, 5]
[2, 3, 1]
[2, 3, 4]
[2, 3, 5]
[2, 4, 1]
[2, 4, 3]
[2, 4, 5]
[2, 5, 1]
[2, 5, 3]
[2, 5, 4]
[3, 1, 2]
[3, 1, 4]
[3, 1, 5]
[3, 2, 1]
[3, 2, 4]
[3, 2, 5]
[3, 4, 1]
[3, 4, 2]
[3, 4, 5]
[3, 5, 1]
[3, 5, 2]
[3, 5, 4]
[4, 1, 2]
[4, 1, 3]
[4, 1, 5]
[4, 2, 1]
[4, 2, 3]
[4, 2, 5]
[4, 3, 1]
[4, 3, 2]
[4, 3, 5]
[4, 5, 1]
[4, 5, 2]
[4, 5, 3]
[5, 1, 2]
[5, 1, 3]
[5, 1, 4]
[5, 2, 1]
[5, 2, 3]
[5, 2, 4]
[5, 3, 1]
[5, 3, 2]
[5, 3, 4]
[5, 4, 1]
[5, 4, 2]
[5, 4, 3]
totalCnt : 60
 */