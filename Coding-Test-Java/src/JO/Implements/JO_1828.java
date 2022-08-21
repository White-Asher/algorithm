package JO.Implements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO_1828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		Arrays.sort(arr, new Comparator<int[]>(){
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return Integer.compare(o1[1], o2[1]);
//			}
//		});
		
		Arrays.sort(arr, (o1,o2)-> (o1[1] - o2[1]));
		
		int cnt = 1;
		int maxDegree = arr[0][1];
		for (int i = 1; i < n; i++) {
			if(maxDegree < arr[i][0]) {
				maxDegree = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
