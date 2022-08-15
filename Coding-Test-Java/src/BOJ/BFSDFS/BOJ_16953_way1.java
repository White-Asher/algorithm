package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_way1 {
	static int start, end;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		if (start == end) System.out.println(0);
		else {
			DFS((long) start, 1);
			if (!flag) System.out.println(-1);
		}

	}

	public static void DFS(long x, int cnt) {
		if (x == end) {
			System.out.println(cnt);
			flag = true;
			return;
		}
		if (x > end) return;
		DFS(x * 2, cnt + 1);
		DFS(x * 10 + 1, cnt + 1);
	}
}
