import sys
input = sys.stdin.readline


def fibo_memo(x):
    if x == 0:
        memo[x] = [1, 0]
        return memo[x]
    elif x == 1:
        memo[x] = [0, 1]
        return memo[x]
    elif x in memo:
        return memo[x]
    else:
        a = fibo_memo(x - 1)[0] + fibo_memo(x - 2)[0]
        b = fibo_memo(x - 1)[1] + fibo_memo(x - 2)[1]
        memo[x] = [a, b]
        return memo[x]


t = int(input())
for _ in range(t):
    n = int(input())
    memo = {}
    f = fibo_memo(n)
    print(f[0], f[1])

# 다른 풀이
# t = int(input())
#
# for _ in range(t):
#     cnt_0 = [1, 0]
#     cnt_1 = [0, 1]
#     n = int(input())
#     if n > 1:
#         for i in range(n - 1):
#             cnt_0.append(cnt_1[-1])
#             cnt_1.append(cnt_0[-2] + cnt_1[-1])
#
#     print(cnt_0[n], cnt_1[n])
# 0의 갯수 = 이전 1의 갯수, 1의 갯수 = 이전 0+이전1 갯수