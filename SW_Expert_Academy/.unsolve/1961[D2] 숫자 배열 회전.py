def rotation(arr, n):
    new_arr = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            new_arr[i][j] = arr[n-1-j][i]
    return new_arr

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]

    arr90 = rotation(arr, n)
    arr180 = rotation(arr90, n)
    arr270 = rotation(arr180, n)
    
    print("#{}".format(test_case))
    for i in range(n):
        print("".join(map(str, arr90[i])), end=" ")
        print("".join(map(str, arr180[i])), end=" ")
        print("".join(map(str, arr270[i])), end=" ")
        print()