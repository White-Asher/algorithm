from collections import deque

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def bfs(x, y):
    queue = deque()
    queue.append((x,y))

    while queue:
        x, y = queue.popleft()

        visited[x][y] = 1

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if nx < 0 or nx >= 16 or ny < 0 or ny >= 16:
                continue

            if arr[nx][ny] == 1:
                continue

            if arr[nx][ny] == 0 and visited[nx][ny] == 0 or arr[nx][ny] == 3:
                visited[nx][ny] = 1
                queue.append((nx,ny))

for test_case in range(1, 11):
    a = int(input())
    arr = [list(map(int, input())) for _ in range(16)]
    visited = [[0]*16 for _ in range(16)]

    lastX = 0
    lastY = 0
    answer = 0

    for i in range(16):
        for j in range(16):
            if arr[i][j] == 2:
                bfs(i, j)
            if arr[i][j] == 3:
                lastX = i
                lastY = j

    if visited[lastX][lastY] == 1:
        answer = 1

    print("#{} {}".format(test_case, answer))