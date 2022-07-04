t = int(input())
for tc in range(1, t+1):
    n, a, b = map(int, input().split())
    if a>b:
        x = b
    else:
        x = a
    if n > a + b:
        y = 0
    else:
        y = a + b -n
    print("#{} {} {}".format(tc, x, y))