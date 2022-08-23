package BOJ.DnC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
	public static long a,b,c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    a = Long.parseLong(st.nextToken());
	    b = Long.parseLong(st.nextToken());
	    c = Long.parseLong(st.nextToken());
	    System.out.println(solution(b));
	}
	
	public static long solution(long b) {
		if(b == 1) return a%c;
		long value = solution(b/2)%c;
		if(b % 2 == 1) return value * value % c * a % c;
		else return value * value % c;
	}
}
