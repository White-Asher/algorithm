# 1번 풀이
import sys
input = sys.stdin.readline
n = int(input())
d = [0] * (n + 1)

for i in range(2, n + 1):

    d[i] = d[i - 1] + 1
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
print(d[n])

# 2번 풀이 (1번보다 오래걸림)
import sys
input = sys.stdin.readline
N = int(input())

dist = [-1] * (N + 3)
dist[1] = 0
dist[2] = dist[3] = 1

for i in range(4, N + 1):
    cnt = 10 ** 6
    if i % 3 == 0:
        cnt = min(dist[i // 3], cnt)
    if i % 2 == 0:
        cnt = min(dist[i // 2], cnt)

    dist[i] = min(dist[i - 1], cnt) + 1

print(dist[N])

# 3번 풀이
import sys
input = sys.stdin.readline

N = int(input())
dist = {1: 0, 2: 1}

def dp(n):
    if n in dist:
        return dist[n]

    cnt = 1 + min(dp(n // 3) + n % 3, dp(n // 2) + n % 2)
    dist[n] = cnt

    return cnt

print(dp(N))

# 참고한 곳: https://myjamong.tistory.com/301

#
# # 시도한 것 (오답)
# from collections import deque
#
# n = int(input())
# dist = [0] * (10**6)
#
# def bfs(start):
#     queue = deque([])
#     queue.append(start)
#
#     while queue:
#         x = queue.popleft()
#         if x == n:
#             print(dist[x])
#             break
#         else:
#             for nx in range(x/3, x/2, x-1):
#                 if nx == x/3 and nx*3 == float(x):
#                     nx = int(nx)
#                     dist[nx] = dist[x] + 1
#                     queue.append(nx)
#                 elif nx == x/2 and nx*2 == float(x):
#                     nx = int(nx)
#                     dist[nx] = dist[x] + 1
#                     queue.append(nx)
#                 else:
#                     nx = int(nx)
#                     dist[nx] = dist[x] + 1
#                     queue.append(nx)
# bfs(n)
#
