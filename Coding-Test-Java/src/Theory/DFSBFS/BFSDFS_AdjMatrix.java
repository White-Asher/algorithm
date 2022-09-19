package Theory.DFSBFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BFSDFS_AdjMatrix {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int edge = sc.nextInt();
		int[][] adjMatrix = new int[N][N]; // 0으로 자동 초기화
		
		for (int i = 0; i < edge; i++) { // 간선정보에 해당하는 부분만 덮어씀
			int start = sc.nextInt();
			int end = sc.nextInt();
			adjMatrix[end][start] = adjMatrix[start][end] = 1; // 무향 그래프
		}
		
		boolean[] visited1 = new boolean[N];
		System.out.print("BFS: ");
		BFS(adjMatrix, visited1);
		
		System.out.println();
		
		boolean[] visited2 = new boolean[N];
		System.out.print("DFS: ");
		DFS(adjMatrix, visited2, 0);
		
		sc.close();
	}
	
	public static void DFS(int[][] adjMatrix, boolean[] visited, int node) {
		visited[node] = true;
		System.out.print((char)(node+'A')+" ");
		for (int i = 0; i < N; i++) {
			if(!visited[i] && adjMatrix[node][i] != 0) {
				DFS(adjMatrix, visited, i);
			}
		}
		// 현 정점의 인접정점들에 큐에 넣어서 차후 탐색하도록 만들기
	}
	
	
	public static void BFS(int[][] adjMatrix, boolean[] visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			System.out.print((char)(q+'A')+" ");
			// 현 정점의 인접정점들에 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[q][i]!=0) {
					visited[i] = true;
					queue.offer(i);
				}
			}
			
		}
	}
}

/*input case
7
8
0 1
0 2
1 3
1 4
3 5
4 5
5 6
2 6
*/
