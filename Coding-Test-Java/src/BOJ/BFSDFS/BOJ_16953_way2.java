package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_way2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		if(start == end) cnt = 0;
		else {
			while (end != start) {
				if (end < start) {
					cnt = -1;
					break;
				}

				if (end % 10 == 1) end /= 10;
				else if (end % 2 == 0) end /= 2;
				else {
					cnt = -1;
					break;
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
