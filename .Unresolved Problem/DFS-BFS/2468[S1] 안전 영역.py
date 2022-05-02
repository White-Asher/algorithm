#  오답
from collections import deque

n = int(input())
graph = []
maxNum = 0

dx = [0,0,-1,1]
dy = [1,-1,0,0]

for i in range(n):
    graph.append(list(map(int,input().split())))
    for j in range(n):
        if graph[i][j] > maxNum:
            maxNum = graph[i][j]

def bfs(x, y, value, visited):
    queue = deque()
    queue.append((x,y))
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            
            if graph[nx][ny] > value and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append((nx, ny))

result = 0
for i in range(maxNum):
    visited = [[0] for _ in range(n)]
    cnt = 0
    
    for j in range(n):
        for k in range(n):
            if graph[j][k] > i and visited[j][k] == 0:
                bfs(j,k,i,visited)
                cnt += 1
    if result < cnt:
        result = cnt

print(result)