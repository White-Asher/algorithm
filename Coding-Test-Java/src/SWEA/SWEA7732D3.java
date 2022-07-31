package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class SWEA7732D3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String[] startTime = br.readLine().split(":");
			String[] endTime = br.readLine().split(":");

			int s = Integer.parseInt(endTime[2])- Integer.parseInt(startTime[2]);
			int m = Integer.parseInt(endTime[1])- Integer.parseInt(startTime[1]);
			int h = Integer.parseInt(endTime[0])- Integer.parseInt(startTime[0]);
			
			if(s < 0) {
				s += 60;
				m -= 1;
			}
			if(m < 0) {
				m += 60;
				h -= 1;
			}
			if(h < 0)
				h +=24;
			
//			System.out.printf("#%d ", tc);
//			if(h < 10) sb.append('0').append(h);
//			else sb.append(h);
//			sb.append(':');
//			
//			if(m<10) sb.append('0').append(m);
//            else sb.append(m);
//            sb.append(':');
// 
//            if(s<10) sb.append('0').append(s);
//            else sb.append(s);
// 
//            sb.append('\n');
//			
//            System.out.println(sb);
            
            DecimalFormat df = new DecimalFormat("00");
            String answer = (df.format(h)+ ":" + df.format(m) +":" +df.format(s));
            System.out.println("#" + tc +" " + answer);
		}
	}
}
