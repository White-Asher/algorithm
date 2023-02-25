package Theory.sort;

import java.util.Arrays;

public class MergeSort_BottomUp {

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

    // Bottom-Up 방식 구현
    private static void mergeSort(int[] arr, int left, int right) {
        /*
        1 - 2 - 4 - 8 - ... 식으로 1부터 서브리스트를 나누는 기준을 두 배씩 늘린다.

        두 부분리스트을 순서대로 병합해준다.
        예를들어 현재 부분리스트의 크기가 1(size=1)일 때
        왼쪽 부분리스트(low ~ mid)와 오른쪽 부분리스트(mid + 1 ~ high)를 생각하면
        왼쪽 부분리스트는 low = mid = 0 이고,
        오른쪽 부분리스트는 mid + 1부터 low + (2 * size) - 1 = 1 이 된다.

        이 때 high 가 배열의 인덱스를 넘어갈 수 있으므로 right 와 둘 중 작은 값이
        병합되도록 해야한다.
         */
        for (int size = 1; size <= right ; size += size) {
            for(int i = 0; i <= right - size; i += (2 * size)) {
                int low = i;
                int mid = i + size - 1;
                int high = Math.min(i + (2 * size) - 1, right);
                merge(arr, low, mid, high);		// 병합작업
            }
        }
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
