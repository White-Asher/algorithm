package SSWtest.BOJ.BOJ_17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281 {
	static int N;
	static final int BASEBALL_PLAYER_NUMBER = 9;
	static final int OUT_CONDITION = 3;
	static int[] playerTempOrder = new int[BASEBALL_PLAYER_NUMBER-1];
	static int[] playerOrder = new int[BASEBALL_PLAYER_NUMBER];
	static int[] inputs = {1,2,3,4,5,6,7,8};
	static int[][] playerScoreArray;
	static int maxScore = 0;
	
	static int TotalCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		inputData();
		permutation(0,0);
		System.out.println(maxScore);
	}
	
	public static void playGame() {
		
		int playerStart = 0;
		int caseScore = 0;
		int[] order = playerOrder;
		
		for(int inning = 0; inning < N; inning++) {
			
			int outCount = 0;
			boolean[] baseCheck = new boolean[4];
			
			outer: while (true) {
	
				for (int player = playerStart; player < BASEBALL_PLAYER_NUMBER; player++) {
					
					int playerScore = playerScoreArray[inning][order[player]];

					switch (playerScore) {
					
					case 0:
						outCount++;
						break;
					case 1:
						for (int base = 3; base >= 1; base--) {
                            if (baseCheck[base]) {
                                if (base == 3) { 
                                	baseCheck[base] = false; 
                                	caseScore++; 
                                    continue;
                                }
                                baseCheck[base] = false;
                                baseCheck[base + 1] = true;
                            }
                        }
						baseCheck[1] = true; 
                        break;
						
					case 2:
						for (int base = 3; base >= 1; base--) {
                            if (baseCheck[base]) {
                                if (base == 3 || base == 2) {
                                	baseCheck[base] = false; 
                                	caseScore++; 
                                    continue;
                                }
                                baseCheck[base] = false;
                                baseCheck[base + 2] = true;
                            }
                        }
						baseCheck[2] = true; 
                        break;
						
					case 3:
						for (int base = 3; base >= 1; base--) {
                            if (baseCheck[base]) { 
                            	baseCheck[base] = false;
                            	caseScore++; 
                            }
                        }
 
						baseCheck[3] = true; 
                        break;
						
					case 4:
						for (int base = 1; base <= 3; base++) {
                            if (baseCheck[base]) {
                            	baseCheck[base] = false;
                            	caseScore++; 
                            }
                        }
						caseScore++; 
                        break;
					}
		
					if (outCount == OUT_CONDITION) {
						playerStart = player + 1;
						if(playerStart == BASEBALL_PLAYER_NUMBER) player = 0;
						break outer;
					}
					
				}
				playerStart = 0;
			}
		}
		
		maxScore = Math.max(maxScore, caseScore);
	}
	
	
	public static void permutation(int cnt, int flag) {
		if(cnt == BASEBALL_PLAYER_NUMBER-1) {
			createOrder();
			playGame();
			return;
		}

		for(int i = 0; i < BASEBALL_PLAYER_NUMBER- 1; i++) {
			if( (flag & 1 << i) != 0) continue;
			playerTempOrder[cnt] = inputs[i];
			permutation(cnt+1, flag | 1 << i);
		}
	}
	
	public static void createOrder() {
		playerOrder[3] = 0;
		for (int i = 0; i < 3; i++) playerOrder[i] = playerTempOrder[i];
		for (int i = 3; i < 8; i++) playerOrder[i+1] = playerTempOrder[i];
	}
	
	public static void inputData() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		playerScoreArray = new int[N][BASEBALL_PLAYER_NUMBER];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < BASEBALL_PLAYER_NUMBER; j++) {
				playerScoreArray[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
	}
}