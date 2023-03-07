package BOJ.Bruteforce.BOJ_9663_G5_Nqueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9663_Way2 {
	static int N;
	static int cnt = 0;

	public static void dfs(int y, int x, int slashFlag, int backslashFlag) {
		if (y == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((x & (1 << i)) == 0 && (slashFlag & (1 << (i + y))) == 0 && (backslashFlag & (1 << (N + i - y))) == 0) {
				dfs(y + 1, x | (1 << i), slashFlag | 1 << ((i + y)), backslashFlag | (1 << (N + i - y)));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		dfs(0, 0, 0, 0);

		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}
}
