package programers;

public class ProL1CalculateTheMissingAmount {
    public static void main(String[] args) {
        ProL1CalculateTheMissingAmountSol proL1CalculateTheMissingAmountSol = new ProL1CalculateTheMissingAmountSol();
        long result = proL1CalculateTheMissingAmountSol.solution(3,20,4);
        System.out.println(result);
    }
}

class ProL1CalculateTheMissingAmountSol {
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