package BOJ.Greedy.BOJ_1202_G2_보석도둑;

import java.io.*;
import java.util.*;

public class BOJ_1202_G2_보석도둑_250607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> list = new ArrayList<>();
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o1.weight - o2.weight;
            }
        });

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        long totalValue = 0;
        int jewelIdx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            while (jewelIdx < N && list.get(jewelIdx).weight <= bags[i]) {
                pq.add(list.get(jewelIdx).value);
                jewelIdx++;
            }

            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }
        }

        System.out.println(totalValue);

    }

    static class Jewel {
        int weight;
        int value;
        public Jewel (int _weight, int _value) {
            weight = _weight;
            value = _value;
        }
    }
}
