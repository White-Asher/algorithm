import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(x):
    queue = deque([x])
    visited[x] == 1
    # 왜 방문 처리를 할까?
    # https://www.acmicpc.net/board/view/89791
    while queue:
        q = queue.popleft()
        for j in graph[q]:
            if visited[j] == 0:
                queue.append(j)
                visited[j] = 1

result = 0

for i in range(1, n+1):
    if visited[i] == 0:
        bfs(i)
        result += 1
print(result)