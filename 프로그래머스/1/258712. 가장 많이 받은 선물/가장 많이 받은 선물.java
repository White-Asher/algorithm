import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> giftRecord = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        Map<String, Integer> nextMonRecvGift = new HashMap<>();
        
        for(String f : friends) {
            giftRecord.put(f, new HashMap<>());
            giftScore.put(f, 0);
            nextMonRecvGift.put(f, 0);
        }
        
        for(String g : gifts) {
            String[] input = g.split(" ");
            String sender = input[0];
            String receiver = input[1];
            
            giftRecord.get(sender).put(receiver, giftRecord.get(sender).getOrDefault(receiver, 0) + 1);
            giftScore.put(sender, giftScore.get(sender) + 1);
            giftScore.put(receiver, giftScore.get(receiver) - 1);
        }
        
        for(String sender : friends) {
            for(String receiver : friends) {
                if(!sender.equals(receiver)) {
                    int giftFromSender = giftRecord.get(sender).getOrDefault(receiver, 0);
                    int giftFromReceiver = giftRecord.get(receiver).getOrDefault(sender, 0);
                    
                    // 준 양이 더 많다면
                    if(giftFromSender > giftFromReceiver) {
                        nextMonRecvGift.put(sender, nextMonRecvGift.get(sender) + 1);
                    // 선물 주고받은 수가 같다면 선물지수가 더 큰 사람이 선물지수가 낮은 사람에게 선물받음
                    } else if (giftFromSender == giftFromReceiver &&
                              giftScore.get(sender) > giftScore.get(receiver)) {
                        nextMonRecvGift.put(sender, nextMonRecvGift.get(sender) + 1);
                    }
                }
            }
        }
        
        return Collections.max(nextMonRecvGift.values());
    }
}