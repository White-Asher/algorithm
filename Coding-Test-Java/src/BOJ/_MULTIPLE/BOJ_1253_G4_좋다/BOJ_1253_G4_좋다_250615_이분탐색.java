package BOJ._MULTIPLE.BOJ_1253_G4_좋다;

import java.util.*;
import java.io.*;

public class BOJ_1253_G4_좋다_250615_이분탐색 {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        // END-INPUT
        int ans = 0;

        Arrays.sort(arr);

        for(int k = 0; k < N; k++) {
            long target = arr[k];

            boolean isGood = false;
            for(int i = 0; i < N; i++) {
                if(i == k) {
                    continue;
                }

                long search = target - arr[i];

                int lb = lowerBound(search);
                int ub = upperBound(search);
                int count = ub - lb; // 찾으려는 값의 개수

                if(count == 0) { // 찾으려는 값 없으면 그냥 리턴
                    continue;
                }

                // 해당 값을 사용하지 못하는 경우 제외 (i != search / k != search 조건)

                // 1. 만약 첫 번째 수(arr[i])가 찾아야 할 값(search)과 같다면,
                //    후보 중 하나는 arr[i] 자신이므로 제외해야 함
                if (arr[i] == search) count--;
                // 2. 만약 목표값(arr[k])이 찾아야 할 값(search)과 같다면,
                //    후보 중 하나는 arr[k] 자신이므로 제외해야 함
                if (arr[k] == search) count--;

                // 위 조건 제외하고도 남는 후보가 있다면 좋은 수 개수
                if (count > 0) {
                    isGood = true;
                    break;
                }

            }

            if(isGood) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    // target 값 처음 나오는 수 인덱스 반환
    public static int lowerBound(long target) {
        int start = 0;
        int end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    // target 값을 초과하는 수가 처음 나타나는 인덱스를 반환
    public static int upperBound(long target) {
        int start = 0;
        int end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
