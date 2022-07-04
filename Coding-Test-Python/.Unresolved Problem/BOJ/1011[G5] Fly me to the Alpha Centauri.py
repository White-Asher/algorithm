t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    distance = m - n

    cnt = 0
    i = 1
    move = 0
    while move < distance:
        cnt += 1
        move += i
        if cnt % 2 == 0:
            i += 1
    print(cnt)