//package _Playground._Practice.day1006;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class P {
//	static int N, R;
//	static int[] nums;
//	static int[] input;
//	static boolean[] select;
//	static StringTokenizer st;
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		R = Integer.parseInt(st.nextToken());
//
//		input = new int[N];
//		nums = new int[R];
//		select = new boolean[N];
//
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			input[i] = Integer.parseInt(st.nextToken());
//		}
//
//		permu(0);
//	}
//
//	private static void permu(int cnt) {
//		if(cnt == R) {
//			System.out.println(Arrays.toString(nums));
//			return;
//		}
//
//		for (int j = 0; j < N; j++) {
//			if(select[j]) continue;
//			select[j] = true;
//			nums[cnt] = input[j];
//			permu(cnt+1);
//			select[j] = false;
//		}
//
//	}
//}
