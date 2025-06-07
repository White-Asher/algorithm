package BOJ.DataStructure.SegmentTree.BOJ_2042_G1_구간합구하기;

import java.io.*;
import java.util.*;

public class BOJ_2042_G1_구간합구하기_250604 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        SegmentTree segTree = new SegmentTree(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            if(m1 == 1) {
                long m3 = Long.parseLong(st.nextToken());
                segTree.update(m2 - 1, m3);
            } else {
                int m3 = Integer.parseInt(st.nextToken());
                sb.append(segTree.sum(m2 - 1, m3 - 1)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class SegmentTree {
        long[] tree; // 세그먼트 트리 저장 배열
        long[] numArr; // 원본 배열
        int n; // 원본 배열 크기

        public SegmentTree(long[] arr) {
            n = arr.length;
            numArr = arr;
            tree = new long[4 * n];
            build(0, 0, n - 1);
        }

        public void build(int node, int start, int end) {
            if(start == end) {
                // 리프 노드일 경우에 원본 배열의 값을 저장
                tree[node] = numArr[start];
            } else {
                int mid = (start + end) / 2;
                build(2 * node + 1, start, mid);
                build(2 * node + 2, mid + 1, end);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public long sum(int node, int start, int end, int left, int right) {
            if(right < start || end < left) {
                return 0;
            }
            if(left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            long leftSum = sum(2 * node + 1, start, mid, left, right);
            long rightSum = sum(2 * node + 2, mid + 1, end, left, right);
            return leftSum + rightSum;
        }

        public void update (int node, int start, int end, int idx, long val) {
            if(start == end) {
                 numArr[idx] = val;
                 tree[node] = val;
            } else {
                int mid = (start + end) / 2;
                if(start <= idx && idx <= mid) {
                    update(2 * node + 1, start, mid, idx, val);
                } else {
                    update(2 * node + 2, mid + 1, end, idx, val);
                }
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public long sum(int left, int right) {
            return sum(0,0, n -1 ,left, right);
        }

        public void update(int idx, long val) {
            update(0,0, n - 1, idx, val);
        }
    }

}
