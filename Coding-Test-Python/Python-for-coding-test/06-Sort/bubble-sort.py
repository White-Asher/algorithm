array = [34, 6, 41, 16, 38, 36, 28, 19, 45, 43, 49]

for i in range(len(array)):
    for j in range(0, len(array)-i-1):
        # 만약 현재 인덱스의 값이 다음 인덱스의 값보다 클 경우 실행함.
        if array[j] > array[j + 1]:
            array[j], array[j + 1] = array[j + 1], array[j]

print(array)