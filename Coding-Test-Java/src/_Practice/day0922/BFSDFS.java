package _Practice.day0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSDFS {
	static int N;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int edge = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N];
		
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjMatrix[start][end] = adjMatrix[end][start] = 1;
	
		}
		
		
		boolean[] visited1 = new boolean[N];
		System.out.print("BFS: ");
		BFS(adjMatrix, visited1);
		
		boolean[] visited2 = new boolean[N];
		System.out.print("DFS: ");
		DFS(adjMatrix, visited2, 0);
		
	}


	private static void BFS(int[][] adjMatrix, boolean[] visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			System.out.println((char)(q+'A')+" ");
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[q][i] != 0) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	
	
	private static void DFS(int[][] adjMatrix, boolean[] visited, int node) {
		visited[node] = true;
		System.out.println((char)(node+'A')+" ");
		for (int i = 0; i < N; i++) {
			if(!visited[i] && adjMatrix[node][i] != 0) {
				DFS(adjMatrix, visited, i);
			}
		}
	}
}
