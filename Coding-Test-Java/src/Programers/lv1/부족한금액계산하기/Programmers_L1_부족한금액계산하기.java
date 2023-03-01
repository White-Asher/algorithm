package Programers.lv1.부족한금액계산하기;

public class Programmers_L1_부족한금액계산하기 {
    public static void main(String[] args) {
        Solution proL1CalculateTheMissingAmountSol = new Solution();
        long result = proL1CalculateTheMissingAmountSol.solution(3,20,4);
        System.out.println(result);
    }
}

class Solution {
    public long solution(int price, int money, int count) {
        long sumPrice = 0;
        for (int i = 1; i <= count; i++) {
            sumPrice += price*i;
        }
        if(sumPrice >= money){
            return sumPrice - money;
        }
        return 0;
    }
}