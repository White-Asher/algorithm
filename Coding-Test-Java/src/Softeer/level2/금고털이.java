package Softeer.level2;

import java.util.*;
import java.io.*;

public class 금고털이 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 귀금속 담을 리스트 선언
        List<Gold> goldList = new ArrayList<>();

        // 귀금속 정보 담기
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int amount = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            goldList.add(new Gold(amount, price));
        }

        // 귀금속 리스트 정렬
        Collections.sort(goldList);

        int ans = 0;

        // 가장 비싼 귀금속 부터 가격 출력
        for(int index = 0; index < goldList.size(); index++ ) {
            int curAmount = goldList.get(index).getAmount();
            int curPrice = goldList.get(index).getPrice();

            // 전부 담을 수 있다면
            if(W >= curAmount) {
                ans += curAmount * curPrice;
                W -= curAmount;
            }
            // 전부 담을 수 없으면 담을 수 있는 만큼 담기
            else {
                ans += W * curPrice;
                W = 0;
            }
            // 남은 공간이 없으면 반복문 중지
            if(W == 0) {
                break;
            }
        }

        System.out.println(ans);
    }
}
class Gold implements Comparable<Gold>{
    private int amount; // 양
    private int price; // 무게당 가치

    public int getAmount() {
        return this.amount;
    }

    public int getPrice() {
        return this.price;
    }

    public Gold(int amount, int price) {
        this.amount = amount;
        this.price = price;
    }

    // 가치 순으로 정렬함.
    @Override
    public int compareTo(Gold o) {
        return o.getPrice() - getPrice();
    }
}
