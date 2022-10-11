package BOJ.BFSDFS.BOJ_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_TRY1 {
	static int N, K, ans;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new int[1000001];
		ans = BFS(N);
		System.out.println(ans);
	}
	
	public static int BFS(int x) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(x);
		visited[x] = 0;
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			if(q == K) return visited[q];
			
			if(q-1 >= 0 && visited[q-1] == 0) {
				visited[q-1] = visited[q] + 1;
				queue.add(q-1);
			}
			
			if(q+1 <= 1000000 && visited[q+1] == 0) {
				visited[q+1] = visited[q] + 1;
				queue.add(q+1);
			}
			
			if(q*2 <= 1000000 && visited[q*2] == 0) {
				visited[q*2] = visited[q] + 1;
				queue.add(q*2);
			}
		}
		
		return 0;
	}
}
