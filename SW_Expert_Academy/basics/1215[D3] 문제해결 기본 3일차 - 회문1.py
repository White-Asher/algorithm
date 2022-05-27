t = 10
for tc in range(1, t+1):
    p = int(input())
    n = 8
    arr = list(input() for _ in range(n))

    cnt = 0

    for i in range(0, n):
        for j in range(0, n-p+1):
            if arr[i][j:j+p] == arr[i][j:j+p][::-1]:
                cnt += 1

    for j in range(0, n):
        for i in range(0, n-p+1):
            char = ''
            for k in range(i, i+p):
                char += arr[k][j]
            if char == char[::-1]:
                cnt += 1

    print("#{} {}".format(tc, cnt))