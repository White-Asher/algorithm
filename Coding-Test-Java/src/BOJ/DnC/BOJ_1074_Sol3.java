package BOJ.DnC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Sol3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = (int)Math.pow(2, N) / 2;
		int ans = 0;
		while (N-- > 0) {
			int skip = 3;
			if 		(r <  n && c <  n) skip = 0;  // 1사분면
			else if (r <  n && c >= n) skip = 1;  // 2사분면
			else if (r >= n && c <  n) skip = 2;  // 3사분면
			
			ans += n * n * skip;
			r %= n;
			c %= n;
			n = (int)Math.pow(2, N) / 2;
		}
		System.out.println(ans);
	}
}