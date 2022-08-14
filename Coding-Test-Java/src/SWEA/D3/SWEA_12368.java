package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class SWEA_12368 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SWEA/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			ans = (x + y)%24;
			
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
