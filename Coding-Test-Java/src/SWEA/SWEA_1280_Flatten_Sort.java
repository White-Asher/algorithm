package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1280_Flatten_Sort {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			int cnt = Integer.parseInt(br.readLine());

			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list);
			while(cnt-- > 0) {
				Collections.sort(list);
				list.set(99, list.get(99)-1);
				list.set(0, list.get(0)+1);

			}
		
			int result = Collections.max(list) - Collections.min(list);
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}