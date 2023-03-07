package BOJ.Bruteforce.BOJ_9663_G5_Nqueen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9663_Way1 {
	static int n, count;
	static int[] nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		count = 0;
		nums = new int[n];
		solution(0);
		System.out.println(count);
	}
	
	public static void solution(int idx) {
		
		if(idx == n) {
			count++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			nums[idx] = i;
			if(isPossible(idx)) solution(idx+1);
		}
	}
	
	public static boolean isPossible(int idx) {
		for (int i = 0; i < idx; i++) {
			if(nums[idx] == nums[i] || idx -i == Math.abs(nums[idx] - nums[i])) {
				return false;
			}
		}
		return true;
	}
	
}
