import java.util.*;

class Solution {
    static int join;
    static int price;
    static int[] emoticonRate;
    static int[] saleRates = {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 이모티콘 할인률 조합용 배열
        emoticonRate = new int[emoticons.length];
        // 이모티콘 할인률 조합
        comb(0, 0, users, emoticons);
        int[] answer = {join, price};
        
        return answer;
    }
    
    // 계산 메서드
    static void calculate(int[][] users, int[] emoticons) {
        int curJoin = 0; // 특정 조합 할인률일떄 가입자수
        int curPrice = 0; // 특정 조합 할인률일때 수익금 수
        
        for(int i = 0; i < users.length; i++) {
            int purchaseRate = users[i][0]; // 할인률 기준
            double priceLimit = (double) users[i][1]; //금액 기준
            double curUserPurchaseAmount = 0; // 현재 유저 총 이모티콘 구매 금액
            
            int idx = 0;
            for(int e : emoticonRate) {
                if(purchaseRate <= e) {
                    curUserPurchaseAmount += ((double) emoticons[idx] * ((double) (100 - e) / 100) );
                }
                idx++;
            }
            
            if(curUserPurchaseAmount >= priceLimit) {
                curJoin++;
            } else {
                curPrice+=curUserPurchaseAmount;
            }
            
        }
        
        if(curJoin > join) {
            join = curJoin;
            price = curPrice;
        } else if(curJoin == join && curPrice > price) {
            price = curPrice;
        }
        
    }
    
    // 할인률 조합 메서드
    static void comb(int index, int cnt, int[][] users, int[] emoticons) {
        if(index == emoticonRate.length) {
            calculate(users, emoticons);
            return;
        }
        
        for(int i = 0; i < saleRates.length; i++) {
            emoticonRate[index] = saleRates[i];
            comb(index + 1, i + 1, users, emoticons);
        }
        
    }
}