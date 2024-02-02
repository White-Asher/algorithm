//package _Playground._Practice.day1006;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class C {
//	static int[] nums;
//	static int[] input;
//	static int N, R;
//
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		R = Integer.parseInt(br.readLine());
//		nums = new int[R];
//		input = new int[N];
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i <N ; i++) {
//			input[i] = Integer.parseInt(st.nextToken());
//		}
//
//		comb(0, 0);
//
//	}
//
//
//	private static void comb(int cnt, int start) {
//		if(cnt == R) {
//			System.out.println(Arrays.toString(nums));
//			return;
//		}
//
//		for (int i = start; i < N; i++) {
//			nums[cnt] = input[i];
//			comb(cnt+1, i+1);
//		}
//	}
//
//
//}
