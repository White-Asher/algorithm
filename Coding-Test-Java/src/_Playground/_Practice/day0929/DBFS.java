//package _Playground._Practice.day0929;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class DBFS {
//	static int N;
//	static StringTokenizer st;
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int edge = Integer.parseInt(br.readLine());
//		int[][] mat = new int[N][N];
//
//		for (int i = 0; i < edge; i++) {
//			st = new StringTokenizer(br.readLine());
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			mat[start][end] = mat[end][start] = 1;
//		}
//
//		boolean[] visited1 = new boolean[N];
//		System.out.println("BFS: ");
//		BFS(mat, visited1);
//
//
//		boolean[] visited2 = new boolean[N];
//		System.out.println("DFS: ");
//		DFS(mat, visited2, 0);
//	}
//
//	private static void DFS(int[][] mat, boolean[] visited2, int node) {
//		visited2[node] = true;
//		System.out.println((char)(node+'A')+" ");
//		for (int i = 0; i < N; i++) {
//			if(!visited2[i] && mat[node][i] != 0) {
//				DFS(mat, visited2, i);
//			}
//		}
//
//	}
//
//	private static void BFS(int[][] mat, boolean[] visited1) {
//		Queue<Integer> queue = new ArrayDeque<Integer>();
//		visited1[0] = true;
//		queue.offer(0);
//
//		while(queue.size() != 0) {
//			int q = queue.poll();
//			System.out.println((char)(q+'A')+" ");
//
//			for (int i = 0; i < N; i++) {
//				if(!visited1[i] && mat[q][i] != 0) {
//					visited1[i] = true;
//					queue.offer(i);
//				}
//			}
//		}
//
//	}
//
//}
