package BOJ.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {
	static int N, M;
	static int[] inDegree;
	static ArrayList<Integer>[] list;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		input();
		TopoSort();
		System.out.println(sb);
	}
	
	public static void TopoSort() {
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) if(inDegree[i] == 0) queue.add(i);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current+" ");
			
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				if(--inDegree[next] == 0) queue.add(next);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inDegree = new int[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N ; i++) list[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			inDegree[end]++;
		}
	}
}
