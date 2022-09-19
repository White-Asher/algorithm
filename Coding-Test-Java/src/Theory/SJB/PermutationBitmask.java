package Theory.SJB;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitmask {
	static int N, R, totalCnt;
	static int[] input, num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		num = new int[R];
		
		for (int i = 0; i < N; i++) input[i] = sc.nextInt();
		permutationBitmask(0, 0);
		System.out.println(totalCnt);
	}
	
	public static void permutationBitmask(int cnt, int flag) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & 1 << i)!= 0) continue;
			num[cnt] = input[i];
			permutationBitmask(cnt+1, flag | 1 << i);
			
		}
	}
}
