package BOJ.DataStructure.PriorityQueue;

import java.io.*;
import java.util.*;

public class BOJ_11286 {
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
					return Math.abs(o1) - Math.abs(o2);
				}
		});
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i <n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) queue.offer(num);
			else {
				if(queue.size() == 0) bw.write("0\n");
				else bw.write(queue.poll()+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
