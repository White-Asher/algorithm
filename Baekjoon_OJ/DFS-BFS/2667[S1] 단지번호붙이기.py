import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
house = [list(map(int, str(input().rstrip()))) for _ in range(n)]
# 숫자 자릿수 list 만들기
# https://bmy1320.tistory.com/entry/Python-%EC%88%AB%EC%9E%90-%EC%9E%90%EB%A6%BF%EC%88%98-list-%EB%A7%8C%EB%93%A4%EA%B8%B0-%ED%8C%8C%EC%9D%B4%EC%8D%AC-list

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = 1
    cnt = 0

    while queue:
        x, y = queue.popleft()
        cnt += 1

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 <= nx < n and 0 <= ny < n:
                if visited[nx][ny] == 0 and house[nx][ny] == 1:
                    visited[nx][ny] = 1
                    queue.append((nx, ny))
    return cnt

    if len(queue) == 0:
        cnt_list.append(cnt)

visited = [[0]*n for _ in range(n)]
cnt_list = []

for i in range(n):
    for j in range(n):
        if visited[i][j] == 0 and house[i][j] == 1:
            result = bfs(i, j)
            cnt_list.append(result)

print(len(cnt_list))
cnt_list.sort()
for i in cnt_list:
    print(i)

# 또 다른 짧은 풀이
n=int(input())
grid=[input() for _ in range(n)]
visited=[[0]*n for _ in range(n)]
count=0
sectors=0
counts=[]

def dfs(y,x):
    global count
    visited[y][x]=1
    count+=1
    for ny,nx in ((y-1,x),(y,x+1),(y+1,x),(y,x-1)):
        if 0<=ny<n and 0<=nx<n and grid[ny][nx]=='1' and not visited[ny][nx]:
            dfs(ny,nx)

for i in range(n):
    for j in range(n):
        if grid[i][j]=='1' and not visited[i][j]:
            sectors+=1
            dfs(i,j)
            counts.append(count)
            count=0

print(sectors)
counts.sort()
for x in counts:
    print(x)