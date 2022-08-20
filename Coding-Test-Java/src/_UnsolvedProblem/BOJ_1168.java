package _UnsolvedProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1168 {
	static int[] arr, tree;
	static int n, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		tree = new int[n*4];
		arr = new int[n];
		int val = 1;
		for (int i = 0; i < n; i++) {
			arr[i] = val++; 
		}
		
		
		
	}
	
	public static int init(int start, int end, int node){
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return tree[node] + init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
	public static void update(int start, int end, int node, int index, int diff) {
		if(index < start || index > end) return;
		tree[node] += diff;
		if(start == end) return;
		
		int mid = (start+end)/2;
		update(start, mid, node*2, index, diff);
		update(mid+1, end, node*2+1, index, diff);
	}
	
}
