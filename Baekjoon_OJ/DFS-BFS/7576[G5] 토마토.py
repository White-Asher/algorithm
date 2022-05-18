from collections import deque
import sys
input = sys.stdin.readline

graph = []
queue = deque([])
m, n = map(int, input().split())

for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(m):
        if graph[i][j] == 1:
            queue.append([i,j])

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def bfs():
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<n and 0<=ny<m:
                if graph[nx][ny] == 0:
                    graph[nx][ny] = graph[x][y] + 1
                    queue.append([nx,ny])

bfs()
result = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            print(-1)
            exit(0)
        result = max(result, graph[i][j])

print(result - 1)


















