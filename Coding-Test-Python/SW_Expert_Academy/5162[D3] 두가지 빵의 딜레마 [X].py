T = int(input())
for tc in range(1, 1 + T):
    a, b, c = map(int, input().split())
    if a >= b:
        res = c // b
    else:
        res = c // a
    print('#{} {}'.format(tc, res))