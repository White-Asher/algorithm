package BOJ.DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            int num = queue.indexOf(input);
            int half_idx;

            if(queue.size() % 2 == 0){
                half_idx = queue.size()/2-1;
            } else {
                half_idx = queue.size()/2;
            }

            if(num <= half_idx){
                for (int j = 0; j < num; j++) {
                    queue.addLast(queue.removeFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < queue.size() - num; j++) {
                    queue.addFirst(queue.removeLast());
                    count++;
                }
            }
            queue.pollFirst();
        }


        System.out.println(count);


    }
}
