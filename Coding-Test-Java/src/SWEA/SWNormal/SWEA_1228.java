package SWEA.SWNormal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1228 {
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> data = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			for(int a = 0; a < N; a++) {
				data.add(Integer.parseInt(st.nextToken()));
			}
			
			int fN = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < fN; i++) {
				String c = st.nextToken();
				int addIdx = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < M ; j++) {
					data.add(addIdx, Integer.parseInt(st.nextToken()));
					addIdx++;
				}
			}
	
			System.out.printf("#%d ", tc);
			for(int idx = 0; idx <10; idx++) {
				System.out.print(data.get(idx)+" ");
			}
			System.out.println();
		}
	}
}
