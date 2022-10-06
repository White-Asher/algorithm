package SSWtest.SWEA.SWEA_2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class SWEA_2115_COPY2 {
	static class Honey{
	int y;
	int x;
	int amount;
		public Honey(int y, int x, int amount) {
			this.y = y;
			this.x = x;
			this.amount = amount;
		}
	}
	static int n,m,c;
	static int ans, idx, temp;
	static int[][] map;
	static Honey[] honey;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			honey = new Honey[n * n];
			
			ans = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			getHoney();
			findMax();
			sb.append("#" + t + " ");
			sb.append(ans + "\n");
			
		}
		System.out.println(sb);
		
	}


	public static void getHoney() {
		idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-m+1; j++) {
				temp = 0;
				int sum = 0;
				int[] nums = new int[m];
				
				// m개의 칸에서 꿀 채취
				for (int k = j; k < j + m; k++) {
					sum += map[i][k];
					nums[k-j] = map[i][k];
				}
				
				// 꿀의 양이 c를 넘어간다면 부분집합 선택하기
				if(sum > c) {
					pickNum(nums, new boolean[m], 0 ,0);
				}
				// c범위를 넘지 않으면 전체 넣기 
				else {
					for (int k = 0; k < m; k++) {
						temp += nums[k] * nums[k];
					}
				}
				honey[idx++] = new Honey(i,j,temp);
			}
		}
		
	}
	private static void pickNum(int[] nums, boolean[] isSelected, int depth, int sum) {
		if(depth == m) {
			if(sum > c)
				return;
			int res = 0;
			for (int i = 0; i < m; i++) {
				if(isSelected[i]) res += nums[i] * nums[i];
			}
			temp = Math.max(temp, res);
			return;
		}
		isSelected[depth] = true;
		pickNum(nums, isSelected, depth+1, sum + nums[depth]);
		
		isSelected[depth] = false;
		pickNum(nums, isSelected, depth+1, sum);
	}
	
	public static void findMax() {
		for (int i = 0; i < idx - 1; i++) {
			for (int j = 0; j < idx; j++) {
				if(honey[i].amount + honey[j].amount > ans) {
					if(isValid(honey[i], honey[j])) {
						ans = honey[i].amount + honey[j].amount;
					}
				}
			}
		}
		
	}
	
	private static boolean isValid(Honey a, Honey b) {
		if(a.y == b.y) {
			if(b.x-a.x<m)
				return false;
		}
		return true;
	}


}
