import sys
input = sys.stdin.readline
from collections import deque

dx = [-1,0,1,-1,1,-1,0,1]
dy = [1,1,1,0,0,-1,-1,-1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = 1

    while queue:
        x, y = queue.popleft()

        for k in range(0, 8):
            nx = dx[k] + x
            ny = dy[k] + y

            if nx >= 0 and nx < h and ny >= 0 and ny < w:
                if ground[nx][ny] == 1 and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append((nx, ny))

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    visited = [[0] * (w) for _ in range(h)]
    ground = [list(map(int, input().split())) for _ in range(h)]
    cnt = 0

    for i in range(h):
        for j in range(w):
            if ground[i][j] == 1 and visited[i][j] == 0:
                bfs(i, j)
                cnt += 1
    print(cnt)

