package _aPractice.day0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subsettest {
	static int N;
	static boolean[] isSelect;
	static int[] input;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		isSelect = new boolean[N];
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
	}

	private static void subset(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(isSelect[i] ? input[i] : "X");
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		isSelect[cnt] = true;
		subset(cnt+1);
		isSelect[cnt] = false;
		subset(cnt+1);
		
	}
	
}
