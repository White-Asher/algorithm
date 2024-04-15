package BOJ.DataStructure.Queue.BOJ_2161_S1_카드1;

import java.util.*;
import java.io.*;
public class BOJ_2161_S1_카드1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(queue.size() != 1) {
            sb.append(queue.poll()).append(" ");
            queue.add(queue.poll());
        }
        sb.append(queue.poll());
        System.out.println(sb);
    }
}
