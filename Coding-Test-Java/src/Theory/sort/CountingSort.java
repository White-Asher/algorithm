package Theory.sort;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2, 2};
        int[] countArr = new int[arr.length];

        for (int j : arr) {
            countArr[j] += 1; // 각 데이터에 해당하는 인덱스의 값 증가
        }
        for (int i = 0; i < arr.length; i++) { // 배열에 기록된 정렬 정보 확인
            for (int j = 0; j < countArr[i]; j++) {
                System.out.print(i + " "); // 띄어쓰기를 기준으로 등장한 횟수만큼 인덱스 출력
            }
        }
    }
}
