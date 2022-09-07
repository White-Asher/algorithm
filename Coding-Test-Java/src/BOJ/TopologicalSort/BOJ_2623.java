//package BOJ.TopologicalSort;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class BOJ_2623 {
//	static int N, M;
//	static int[] inDegree;
//	static ArrayList<Integer>[] list;
//	static StringTokenizer st;
//	static StringBuilder sb = new StringBuilder();
//	
//	public static void main(String[] args) {
//		
//	}
//	
//	@SuppressWarnings("unchecked")
//	public static void input() throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		inDegree = new int[N+1];
//		list = new ArrayList[N+1];
//		for (int i = 1; i <= N ; i++) list[i] = new ArrayList<>();
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int count = Integer.parseInt(st.nextToken());
//			int first = Integer.parseInt(st.nextToken());
//			for(int j = 1; j < count; j++) {
//				
//			}
//		}
//	
//	
//}
