package SWEA.D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {
	static StringTokenizer st;
	static int a[];
	static int b[];
	static int win, defeat;
	static int totalCnt;
	static int nums[];
	static boolean isSelect[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			a = new int[9];
			b = new int[9];
			nums = new int[9];
			boolean[] cardCheck = new boolean[19];
			isSelect = new boolean[9];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int inputNum = Integer.parseInt(st.nextToken());
				a[i] = inputNum;
				cardCheck[inputNum] = true; 
			}
			
			win = 0;
			defeat = 0;
			
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if(cardCheck[i]) continue;
				b[idx] = i;
				idx++;
			}
		
			permutation(0);
			System.out.printf("#%d %d %d%n", tc, win, defeat);
		}
	}
	
	public static void permutation(int cnt) {
		if(cnt == 9) {
			totalCnt++;
			solution();
			return;
		}
		
		for(int i = 0; i< 9; i++) {
			if(isSelect[i]) continue;
			nums[cnt] = b[i];
			isSelect[i] = true;
			permutation(cnt+1);			
			isSelect[i] = false;
		}
	}
	
	public static void solution() {
		int aCount = 0;
		int bCount = 0;
		for(int i = 0; i < 9; i++) {
			if (a[i]> nums[i]) aCount += a[i]+nums[i];
			else if (a[i] < nums[i]) bCount += a[i]+nums[i];
		}
		if(aCount > bCount) win++;
		else if (aCount < bCount) defeat++;
	}
	
	
}
