import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        List<Integer> list = new ArrayList<>();
        
        int cnt = 0;
        for(int i = 0; i < moves.length; i++) {
            int tar = moves[i]-1;
            for(int j = 0; j < board.length; j++) {
                if(board[j][tar] != 0) {
                    // System.out.println("tar : " + board[j][tar]);
                    list.add(board[j][tar]);
                    board[j][tar] = 0;
                    break;
                }
            }
            
            while(true) {
                boolean flag = true;
                // System.out.println("size : " + list.size());
                if(list.size() == 1) break;
                for(int w = 0; w < list.size()-1; w++) {
                    int a1 = list.get(w);
                    // System.out.println("a1 : "+ a1);
                    int a2 = list.get(w+1);
                    // System.out.println("a2 : "+ a2);
                    if(a1 == a2) {
                        list.remove(w);
                        list.remove(w);
                        flag = false;
                        cnt+=2;
                    }
                }
                if(flag) {
                    break;
                }
            }
            
        }

        return cnt;
    }
}