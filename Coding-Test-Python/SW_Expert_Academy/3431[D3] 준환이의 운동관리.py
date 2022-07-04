t = int(input())
for tc in range(1, t+1):
    L, U, X = map(int, input().split())
    print("#{}".format(tc), end=' ')
    if L <= X <= U:
        print(0)
    elif X > U:
        print(-1)
    elif X < L:
        print(L-X)
