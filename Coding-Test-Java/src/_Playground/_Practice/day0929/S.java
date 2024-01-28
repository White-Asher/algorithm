//package _Playground._Practice.day0929;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class S {
//	static int N;
//	static int[] inputs;
//	static boolean[] select;
//
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//
//		inputs = new int[N];
//		select = new boolean[N];
//
//		StringTokenizer st =new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			inputs[i] = Integer.parseInt(st.nextToken());
//		}
//
//		subje(0);
//	}
//
//
//	private static void subje(int cnt) {
//		if(cnt == N) {
//			for (int i = 0; i < N; i++) {
//				if(select[i]) System.out.printf("%d ",inputs[i] );
//				else System.out.printf("X ");
//			}
//			System.out.println();
//			return;
//		}
//
//
//			select[cnt] = true;
//			subje(cnt+1);
//			select[cnt] = false;
//			subje(cnt+1);
//
//
//	}
//}
