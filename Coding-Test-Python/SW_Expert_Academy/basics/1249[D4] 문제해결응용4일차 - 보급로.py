from collections import deque

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def bfs(x, y):
    queue = deque()
    queue.append((0,0))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                if field[x][y] + arr[nx][ny] < field[nx][ny]:
                    field[nx][ny] = field[x][y] + arr[nx][ny]
                    queue.append((nx, ny))

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    arr = [list(map(int,input())) for i in range(n)]
    field = [[99999]*n for _ in range(n)]
    field[0][0] = 0
    bfs(0, 0)
    ans = field[-1][-1]

    print("#{} {}".format(test_case, ans))