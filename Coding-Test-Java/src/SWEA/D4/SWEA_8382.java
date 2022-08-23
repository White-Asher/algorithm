package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			boolean flag = (Math.abs(startX - endX) >= Math.abs(startY - endY)) ? true : false;
			
			while(true){
				if(startX == endX && startY == endY) break;
				
				if(flag) {
					if (endX > startX) startX++;
					else startX--;
					flag = false;
				} else {
					if (endY >= startY) startY++;
					else startY--;
					flag = true;
				}
				ans++;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
