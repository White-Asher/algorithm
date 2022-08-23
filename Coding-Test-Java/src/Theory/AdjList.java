package Theory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjList {
	static int N;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int edge = sc.nextInt();
		
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < edge; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			adjList[start].add(end);
			adjList[end].add(start);
		}

		
		System.out.print("BFS: ");
		boolean[] visited1 = new boolean[N+1];
		Arrays.fill(visited1, false);
		BFS(adjList, visited1);
		
		System.out.println();
		
		System.out.print("DFS: ");
		boolean[] visited2 = new boolean[N+1];
		Arrays.fill(visited2, false);
		DFS(adjList, visited2, 0);
		
	}
	public static void DFS(ArrayList<Integer>[] adjList, boolean[] visited, int node) {
		visited[node] = true;
		System.out.print((char)(node+'A')+" ");
		for(int edge: adjList[node]) {
			if(!visited[edge]) {
				DFS(adjList, visited, edge);
			}
		}
	}
	
	public static void BFS(ArrayList<Integer>[] adjList, boolean[] visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			System.out.print((char)(q+'A')+" ");
			for(int edge: adjList[q]) {
				if(!visited[edge]) {
					queue.add(edge);
					visited[edge] = true;
				}
			}
		}
	}
}
