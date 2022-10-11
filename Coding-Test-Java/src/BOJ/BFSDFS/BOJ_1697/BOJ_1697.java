package BOJ.BFSDFS.BOJ_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	static int ans = Integer.MAX_VALUE;
	static int N, K;
	static int[] visited = new int[1000001];
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
			if(q == K) {
				return visited[q];
			}
			
			if(q-1 >= 0 && visited[q-1] == 0) {
				visited[q-1] = visited[q] + 1;
				queue.offer(q-1);
			}
			if(q+1 <= 100000 && visited[q+1] == 0) {
				visited[q+1] = visited[q] + 1;
				queue.offer(q+1);
			}
			if(q*2 <= 100000 && visited[q*2] == 0) {
				visited[q*2] = visited[q] + 1;
				queue.offer(q*2);
			}
			
		}
		return 0;
	}
}