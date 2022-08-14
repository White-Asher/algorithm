package BOJ.Bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BOJ_2961_Pro {
	static int[][] data;
	static int n, ans;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/2961.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		data =new int[n][2];
		ans = 1 << 30;
		ans = Integer.MAX_VALUE;
		ans = (int)1e9;
		ans = 987654321;
		
		for (int i = 0; i < n; i++) {
			data[i][0] = sc.nextInt();
			data[i][0] = sc.nextInt();
		}

		food(0,1,0);
		System.out.println(ans);
		sc.close();
	}
	
	public static void food(int cnt, int s, int b) {
		if(cnt == n) {
			if(ans > Math.abs(s-b) && b != 0) ans = Math.abs(s-b);
			return;
		}
		food(cnt + 1, s *data[cnt][0], b+data[cnt][1]);
		food(cnt + 1, s, b);
	}
}