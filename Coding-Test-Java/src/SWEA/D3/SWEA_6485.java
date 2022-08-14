package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			int inTc = Integer.parseInt(br.readLine());
			int[] bus = new int[5001];
			for(int i = 1; i <=inTc; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				for(int b = left; b <=right; b++) {
					bus[b]++;
				}
			}
			
			System.out.printf("#%d ", tc);
			int P = Integer.parseInt(br.readLine());
			for(int i =0; i< P; i++) {
				int num = Integer.parseInt(br.readLine());
				System.out.print(bus[num]+" ");
			}
			System.out.println();
		}
	}
}
