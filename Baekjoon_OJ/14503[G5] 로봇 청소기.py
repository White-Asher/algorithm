from collections import deque

m, n = map(int, input().split())
r, c, d = map(int, input().split())

graph = []
area = [[0]*m for _ in range(n)]
for i in range(n):
    graph.append(list(map(int, input().split())))
visited = [[0]*m for _ in range(n)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]



bfs(r,c)
graph[r][c] = 2
result = 0

for i in graph:
    result = max(result, max(i))
print(result-1)

