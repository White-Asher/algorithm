import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<HashSet<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++) {
            list.add(new HashSet<Integer>());
        }
        list.get(1).add(N);
        if(number == N) return 1;
        
        for(int i = 2; i <= 8; i++) {
            // 숫자 i개 사용시 저장할 set
            HashSet<Integer> total = list.get(i);
            
            
            for(int j = 1; j < i; j++) {
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i - j);
                
                for(int tara : a) {
                    for(int tarb : b) {
                        total.add(tara + tarb);
                        total.add(tara - tarb);
                        total.add(tara * tarb);
                        if(tara != 0 && tarb != 0) total.add(tara / tarb);
                    } 
                }
                // 88, 888, 8888 이런 숫자 입력
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            
            if(total.contains(number)) return i;
        }
        return -1;
    }
}