n, m = map(int, input().split())
r, c, d = map(int, input().split())

graph = []
for _ in range(n):
    graph.append(list(map(int,input().split())))
visited = [[0]*m for _ in range(n)]

dx = [-1,0,1,0]
dy = [0,1,0,-1]

visited[r][c] = 1
cnt = 1

while 1:
    dire = 0
    for _ in range(4):
        nx = r + dx[(d+3)%4]
        ny = c + dy[(d+3)%4]

        d = (d+3) % 4

        if graph[nx][ny] == 0 and 0<=nx<n and 0<=ny<m:
            if visited[nx][ny] == 0:
                visited[nx][ny] = 1
                cnt += 1
                r = nx
                c = ny
                dire = 1
                break

    if dire == 0:
        if graph[r-dx[d]][c-dy[d]] == 1:
            print(cnt)
            break
        else:
            r = r-dx[d]
            c = c-dy[d]