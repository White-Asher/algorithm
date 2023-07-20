package _UnsolvedProblem.BOJ_1655_G2_가운데를말해요;

import java.io.*;
import java.util.*;

public class BOJ_1655_가운데를말해요 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(((o1, o2) -> o1 - o2));

        for (int i = 0; i < n; i++) {
            int tar = Integer.parseInt(br.readLine());
            if(maxQueue.size() == minQueue.size()) {
                maxQueue.add(tar);
                if(!minQueue.isEmpty() && minQueue.peek() < maxQueue.peek()) {
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(minQueue.poll());
                }
            } else {
                minQueue.add(tar);
                if(minQueue.peek() < maxQueue.peek()) {
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(minQueue.poll());
                }
            }
            sb.append(maxQueue.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
