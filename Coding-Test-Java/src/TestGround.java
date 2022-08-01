
import java.util.*;
import java.io.*;
 
public class TestGround {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
 
		int T = Integer.parseInt(br.readLine());
 
		while(T-- > 0) {
			char[] command = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			boolean seq = true;
 
			Deque<Integer> dq = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine(), "[,]");
			while(st.hasMoreTokens()) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}
 
			for(int i = 0; i < command.length; i++) {
				switch(command[i]) {
				case 'R':
					seq = !seq;
					break;
 
				case 'D':
					if(dq.size() == 0) {
						sb.append("error\n");
						break;
					}
 
					if(seq == true && dq.size() > 0)		dq.pollFirst();
					else if(seq == false && dq.size() > 0)	dq.pollLast();
					break;
				}
			}
 
			if(dq.size() > 0 && seq == true) {
				sb.append('[').append(dq.pollFirst());
				while(dq.size() > 0) {
					sb.append(',').append(dq.pollFirst());
				}
				sb.append(']').append('\n');
			}else if (dq.size() > 0 && seq == false){
				sb.append('[').append(dq.pollLast());
				while(dq.size() > 0) {
					sb.append(',').append(dq.pollLast());
				}
				sb.append(']').append('\n');
			}
		}
		System.out.print(sb);
 
	}
}