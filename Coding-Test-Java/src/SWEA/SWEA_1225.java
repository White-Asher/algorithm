package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1225 {
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Deque<Integer> deque = new ArrayDeque<Integer>();
			for (int i = 0; i < 8; i++) deque.add(Integer.parseInt(st.nextToken()));

			while(deque.peekLast() > 0) {
				for(int i = 1; i <= 5; i++) {
					int first = deque.pollFirst()-i;
					if(first < 0) first = 0;
					deque.add(first);
					if(first == 0) break;
				}
			}

			System.out.printf("#%d ", t);
			for(int i = 0; i < 8; i++) {
				System.out.print(deque.poll() + " ");
			}
			System.out.println();
		}
	}
}
