package SSWtest.SWEA.SWEA_2382;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2382_OtherSol2 {

	static class Colony { 
		int no, x, y, size, dir;

		public Colony(int no, int x, int y, int size, int dir) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.size = size;
			this.dir = dir;
		}
		
		void changeDirection() {
			switch(this.dir) {
				case 0:
					dir = 1;
					break;
				case 1:
					dir = 0;
					break;
				case 2:
					dir = 3;
					break;
				case 3:
					dir = 2;
					break;				
			}
		}
	
	}
	
	static Colony[][] map;
	static Queue<Colony> colonies;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t<=T; t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());	// 콜로니 군집 수			
			colonies = new LinkedList<>();
			map = new Colony[N][N];
			
			for(int i = 0 ; i < C ; i ++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				Colony c = new Colony(i+1, x, y, size, dir);
				colonies.offer(c);	
				map[c.x][c.y] = c;
			}
			
			simulation();
			int result = 0;
			while(!colonies.isEmpty()) {
				result += colonies.poll().size;
			}
			sb.append(result).append("\n");

		}
		System.out.print(sb.toString());

	}
	
	private static final int[] dx = {-1,1,0,0};
	private static final int[] dy = {0,0,-1,1};	
	
	private static void simulation() {
		
		
		for(int i = 0 ; i < M ; i ++) {
			
			//System.out.println(i+"번째 ....");
			// 매턴마다 큐에서 값을 가져오고
			int size = colonies.size();
			for(int j = 0 ; j < size; j++) {
				Colony c = colonies.poll();				
				//System.out.println(c.toString());
				map[c.x][c.y] = null;

				int nx = c.x + dx[c.dir];
				int ny = c.y + dy[c.dir];
				
								
				// 이동한 좌표가 경계면에 도달하면, 뱡향전환 + 인구 감소
				if(nx==0 || ny == 0 || nx == N-1 || ny == N-1) {
					c.size /=2;
					c.changeDirection();
				}
				
				c.x = nx;
				c.y = ny;
				colonies.offer(c);															
			}
			
			
			int size2 = colonies.size();
			for(int k = 0 ; k < size2; k ++) {
				Colony col = colonies.poll();
				if(col.size>0) {
					colonies.offer(col);
				}
			}
			
			int size3 = colonies.size();
			for(int k = 0 ; k < size3; k ++) {
				Colony cur = colonies.poll();
				if(map[cur.x][cur.y] == null) {
					map[cur.x][cur.y] = cur;
				}else {
					Colony prev = map[cur.x][cur.y];
					map[cur.x][cur.y]=prev.size>cur.size?prev:cur;
				}				
				colonies.offer(cur);				
			}
			
			int size4 = colonies.size();
			
			for(int k = 0 ; k < size4; k ++) {
				Colony cur = colonies.poll();
				if(map[cur.x][cur.y].no==cur.no) {
					colonies.offer(cur);
				}else {
					Colony prev = map[cur.x][cur.y];
					colonies.remove(prev);
					map[cur.x][cur.y] = null;
					prev.size+=cur.size;
					colonies.offer(prev);
					map[cur.x][cur.y] = prev;
				}
								
			}
			
		}
	}

}
