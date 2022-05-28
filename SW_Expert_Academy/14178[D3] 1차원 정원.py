import math

T = int(input())
for test_case in range(1, T + 1):
    n, d = map(int, input().split())
    res = n / (d*2+1)

    print("#{} {}".format(test_case, math.ceil(res)))