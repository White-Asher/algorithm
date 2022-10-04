//package SSWtest.SWEA.SWEA_5653;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
///*
//메모리 : 
//실행시간 :
//코드길이 : 
// */
//
//public class SWEA_5653_NotUseMatrix_suspend {
//    static StringTokenizer st;
//    // 세로, 가로, 시간, 결과
//    static int N, M, K, result;
//    
//    // 4방향 탐색
//    static int[] dx = {-1,1,0,0};
//    static int[] dy = {0,0,-1,1};
//    
//    static LinkedList<Cell> cells;
//    
//    static class Cell implements Comparable<Cell>{
//        // 좌표, 생명력, 활성화 시간
//        int x, y, lifePower, lifeTime;
//        boolean visit;
//        public Cell(int x, int y, int lifePower, int lifeTime, boolean visit){
//            this.x = x;
//            this.y = y;
//            this.lifePower = lifePower;
//            this.lifeTime = lifeTime;
//            this.visit = visit;
//        }
//        
//
//        @Override
//		public String toString() {
//			return "Cell [x=" + x + ", y=" + y + ", lifePower=" + lifePower + ", lifeTime=" + lifeTime + ", visit="
//					+ visit + "]";
//		}
//
//
//		// 생명력이 가장 큰 세포부터 내림차순 정렬.
//        @Override
//        public int compareTo(Cell o) {
//            // 비교한 두 셀의 활성화 시간이 다르면 가장 활성화 시간이 빠른 것 부터 정렬.
//            if(lifeTime != o.lifeTime)
//                return lifeTime - o.lifeTime;
//            // 비교한 두 셀의 활성화 시간이 같다면 생명력이 큰 셀부터 정렬.
//           return -(this.lifePower - o.lifePower);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//
//        for(int t = 1; t <= T; t++){
//            st = new StringTokenizer(br.readLine());
//            N = Integer.parseInt(st.nextToken()); // 세로
//            M = Integer.parseInt(st.nextToken()); // 가로
//            K = Integer.parseInt(st.nextToken()); // 시간
//
//            cells = new LinkedList<Cell>(); // 셀 BFS를 위한 큐
//            result = 0;
//
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < M; j++) {
//                    int input = Integer.parseInt(st.nextToken());
//                    // 들어온 값이 세포라면 셀 큐에 넣기 
//                    if(input != 0){
//                        // 세포의 좌표, 세포의 생명력, 활성화 시간 , 방문여부
//                        cells.add(new Cell(i,j, input, input+1, true));
//                        // 해당 세포가 K시간 이후에 비활성화라면 카운트.
//                        if(input*2 > K) result++;
//                    }
//                }
//            }
//            for (Cell cell : cells) {
//				System.out.println(cell);
//			}
//            BFS();
//            System.out.printf("#%d %d\n", t, result);
//        }
//    }
//
//    static void BFS(){
//        int curLifePower = 0;
//        int curLifetime = 0;
//
//        while (curLifetime <= K){
//
//            Cell curCell = cells.poll();
//            curLifePower = curCell.lifePower;
//            curLifetime = curCell.lifeTime;
//
//            // 목표한 시간에 도달했을 때 BFS탈출 (K시간이 지나면..)
//            if(curLifetime > K) break;
//
//            // 4방탐색
//            for (int d = 0; d < 4; d++) {
//                int nx = curCell.x + dx[d];
//                int ny = curCell.y + dy[d];
//
//                boolean searchFlag = false;
//                for (int i = 0; i < cells.size(); i++) {
//					Cell searchCell = cells.get(i);
//					if(searchCell.x == nx && searchCell.y == ny) {
////						System.out.println(searchCell);
//						searchFlag = true;
//						searchCell.visit = true;
//						break;
//					}
//				}
//                
//                if(curLifetime + curLifePower * 2 > K) {
//                	result++;
//                }
//                
//                if(!searchFlag) {
//                	cells.add(new Cell(nx, ny, curLifePower, curLifetime + curLifePower+1, false));
//                }
//                
//            }
//        }
//    }
//}
