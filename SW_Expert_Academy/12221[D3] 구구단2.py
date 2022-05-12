t = int(input())
for tc in range(1, t+1):
    result = -1
    a,b = map(int, input().split())
    if a <= 9 and b <= 9:
        result = a*b
    print("#{} {}".format(tc, result))