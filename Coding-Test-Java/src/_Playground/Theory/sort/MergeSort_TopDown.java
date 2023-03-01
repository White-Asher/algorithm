package _Playground.Theory.sort;

import java.util.Arrays;

public class MergeSort_TopDown {

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    // 합치는 과정에서 정렬하여 원소를 담을 임시 배열
    private static int[] sorted;

    public static void mergeSort(int[] arr) {
        sorted = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        sorted = null;
    }

    // Top-Down 방식 구현
    private static void mergeSort(int[] arr, int left, int right) {
        /*
         * left == right 즉, 부분리스트가 1개의 원소만 갖고 있는 경우
         * 더 이상 쪼갤 수 없으므로 return 함
         */
        if (left == right) return;
        int mid = (left + right) / 2; // 절반 위치
        
        mergeSort(arr, left, mid); // 절반 중 왼쪽 부분리스트(left ~ mid)
        mergeSort(arr, mid+1, right); // 절반 중 오른쪽 부분리스트(mid+1 ~ right)
        
        merge(arr, left, mid, right); // 병합 작업
    }

    /**
     *
     * @param arr : 정렬할 배열
     * @param left : 배열의 시작점
     * @param mid : 배열의 중간점
     * @param right : 배열의 끝점
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int leftStart = left; // 왼쪽 부분리스트 시작점
        int rightStart = mid + 1; // 오른쪽 부분리스트의 시작점
        int index = left; // 채워넣을 배열의 인덱스

        while (leftStart <= mid && rightStart <= right) {
            /*
            왼쪽 부분리스트 leftStart 번째 원소가 오른쪽 부분리스트 rightStart 번째 원소보다 작거나 같을 경우
            왼쪽의 leftStart 번째 원소를 새 배열에 넣고 leftStart 과 index 를 1 증가시킨다.
             */
            if (arr[leftStart] <= arr[rightStart]) {
                sorted[index] = arr[leftStart];
                index++;
                leftStart++;
            }
            /*
            오른쪽 부분리스트 rightStart 원소가 왼쪽 부분리스트 leftStart 번째 원소보다 작거나 같을 경우
            오른쪽의 rightStart 번째 원소를 새 배열에 넣고 rightStart 과 index 를 1 증가시킨다.
             */
            else {
                sorted[index] = arr[rightStart];
                index++;
                rightStart++;
            }
        }

        /*
        왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (leftStart > mid)
		 = 오른쪽 부분리스트 원소가 아직 남아있을 경우
		 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        if (leftStart > mid) {
            while (rightStart <= right) {
                sorted[index] = arr[rightStart];
                index++;
                rightStart++;
            }
        }

        /*
        오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (rightSide > right)
        = 왼쪽 부분리스트 원소가 아직 남아있을 경우
        왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        else {
            while (leftStart <= mid) {
                sorted[index] = arr[leftStart];
                index++;
                leftStart++;
            }
        }

        /*
        정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
         */
        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }

    }
}
