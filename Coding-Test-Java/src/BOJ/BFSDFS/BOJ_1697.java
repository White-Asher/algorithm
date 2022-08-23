package BOJ.BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_1697 {
	static int N, K;
	static final int MAX_VAL = 1000001;
	static int[] visited = new int[MAX_VAL];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		BFS(N);
		System.out.println(visited[K]);
	}
	
	public static int BFS(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = 0;
		
		while(!queue.isEmpty()) {
			int q = queue.remove();
			if(q == K) return visited[q];
		
			if(q-1 >= 0 && visited[q-1] == 0) {
				visited[q-1] = visited[q] + 1;
				queue.offer(q-1);
			}
			if(q+1 <= MAX_VAL && visited[q+1] == 0) {
				visited[q+1] = visited[q] + 1;
				queue.offer(q+1);
			}
			if(q*2 <= MAX_VAL && visited[q*2] == 0) {
				visited[q*2] = visited[q] + 1;
				queue.offer(q*2);
			}
		}
		return 0;
	}
}
