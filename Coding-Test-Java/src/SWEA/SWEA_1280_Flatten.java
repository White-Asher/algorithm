package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1280_Flatten {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			int cnt = Integer.parseInt(br.readLine());

			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			while(cnt-- > 0) {
				int maxIdx = list.indexOf(Collections.max(list));
				int minIdx = list.indexOf(Collections.min(list));
				list.set(maxIdx, list.get(maxIdx)-1);
				list.set(minIdx, list.get(minIdx)+1);

			}
			int result = Collections.max(list) - Collections.min(list);
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}
/*
메모리: 21,040 kb
실행시간: 136 ms
코드길이: 960
*/