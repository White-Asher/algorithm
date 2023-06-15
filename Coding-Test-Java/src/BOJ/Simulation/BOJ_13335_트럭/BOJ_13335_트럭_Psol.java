package BOJ.Simulation.BOJ_13335_트럭;

import java.io.*;
import java.util.*;

public class BOJ_13335_트럭_Psol {
    static int N, W, L;
    static StringTokenizer st;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 차량 수
        W = Integer.parseInt(st.nextToken()); // 다리길이
        L = Integer.parseInt(st.nextToken()); // 하중
        arr = new int[N];

        Queue<Integer> truck = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            truck.add(input);
        }

        int time = 0;
        int sum = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < W; i++) {
            queue.add(0);
        }

        // 트럭 큐가 없어질때까지 반복함.
        while(!queue.isEmpty()) {
            time++;
            sum-= queue.poll();
            if(!truck.isEmpty()) {
                if(truck.peek()+sum<=L) {
                    sum+=truck.peek();
                    queue.offer(truck.poll());
                }else {
                    queue.offer(0);
                }
            }
        }
        System.out.println(time);

    }
}
