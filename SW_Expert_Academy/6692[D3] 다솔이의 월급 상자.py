t = int(input())
for tc in range(1, t+1):
    n = int(input())
    res = 0
    for i in range(n):
        a, b = map(float, input().split())
        res += a*b
    print("#{} {:.6f}".format(tc, res))