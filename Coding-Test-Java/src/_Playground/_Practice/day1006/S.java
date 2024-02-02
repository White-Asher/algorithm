//package _Playground._Practice.day1006;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class S {
//
//	static int N;
//	static int[] input;
//	static boolean[] select;
//
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//
//		input = new int[N];
//		select = new boolean[N];
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			input[i] = Integer.parseInt(st.nextToken());
//		}
//
//		subject(0);
//
//	}
//
//
//	private static void subject(int cnt) {
//		if(cnt == N) {
//			for (int i = 0; i < select.length; i++) {
//				System.out.print(select[i] + " ");
//			}
//			System.out.println();
//			return;
//		}
//		select[cnt] = true;
//		subject(cnt+1);
//		select[cnt] = false;
//		subject(cnt+1);
//
//
//	}
//}
