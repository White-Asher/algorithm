package BOJ.DnC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Sol2 {
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		solve((int)Math.pow(2, Integer.parseInt(st.nextToken())), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
		System.out.println(ans);
	}
	
	public static void solve (int n, int r, int c) {
		if(n == 2) {
			if(r == 0 && c == 1) ans+=1; // 2사분면
			else if(r == 1 && c == 0) ans+=2; // 3사분면
			else if(r == 1 && c == 1) ans+=3; // 4사분면
			return;
		}
			
		int half = n / 2;
		int skip = 3; // 기본은 4사분면에 있다고 가정
		if     (r <  half && c <  half) skip = 0;
		else if(r <  half && c >= half) skip = 1;
		else if(r >= half && c <  half) skip = 2;
		ans += half * half * skip;
		solve(half, r % half, c % half);
	}
}
