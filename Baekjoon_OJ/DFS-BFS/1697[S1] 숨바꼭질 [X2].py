# 참고 : https://wook-2124.tistory.com/273

from collections import deque

n, k = map(int, input().split())

def bfs(x):
    queue = deque([])
    queue.append(x)

    while queue:
        q = queue.popleft()

        if q == k:
            print(dist[q])
            break

        else:
            for i in q-1, q+1, q*2:
                if i >= 0 and i <= MAX and not dist[i]:
                    dist[i] = dist[q] + 1
                    queue.append(i)
MAX = 10**5
dist = [0] * (MAX+1)
bfs(n)

# from collections import deque
# def bfs(n):
#     queue = deque()             # deque는 양쪽에서 입출력 가능
#     queue.append(n)             # q = deque([5])
#     while queue:
#         x = queue.popleft()     # 처음 시작점은 x = 5, q = deque([])
#         if x == k:
#             print(dist[x])
#             break
#         for nx in (x - 1, x + 1, x * 2):    # nx = 4, 6, 10
#             if 0 <= nx <= MAX and not dist[nx]:
#                 dist[nx] = dist[x] + 1
#                 queue.append(nx)    # q = deque([4, 6, "10"])

# MAX = 10 ** 5               # 시간초과 안나게 수 제한
# dist = [0] * (MAX + 1)      # 이동하는 거리를 알기 위한 변수
# n, k = map(int, input().split())
# bfs(n)

# copy practice
# from collections import deque
#
# n, k = map(int, input().split())
#
#
# def bfs(n):
#     queue = deque([])
#     queue.append(n)
#
#     while queue:
#         x = queue.popleft()
#         if x == k:
#             print(dist[x])
#             break
#         else:
#             for nx in (x - 1, x + 1, x * 2):
#                 if 0 <= nx <= MAX and not dist[nx]:
#                     dist[nx] = dist[x] + 1
#                     queue.append(nx)
#
#
# MAX = 10 ** 5
# dist = [0] * MAX
# bfs(n)
