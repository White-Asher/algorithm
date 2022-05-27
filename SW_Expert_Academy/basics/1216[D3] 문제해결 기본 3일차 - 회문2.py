t = 10
for tc in range(1, t+1):
    a = int(input())
    n = 100
    arr = list(input() for _ in range(n))

    cnt = 0
    maxLength = 0

    for i in range(0, n):
        for p in range(0, n):
            for j in range(0, n-p+1):
                if arr[i][j:j+p] == arr[i][j:j+p][::-1]:
                    maxLength = max(p, maxLength)

    for j in range(0, n):
        for p in range(0, n):
            for i in range(0, n-p+1):
                char = ''
                for k in range(i, i+p):
                    char += arr[k][j]
                if char == char[::-1]:
                    maxLength = max(p, maxLength)

    print("#{} {}".format(tc, maxLength))