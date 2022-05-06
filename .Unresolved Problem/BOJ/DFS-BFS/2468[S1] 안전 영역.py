# DFS
n = int(input())
maxNum = 0
# 2차원 리스트의 맵 정보 입력 받기
safearea = []
graph = []

for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        if graph[i][j] > maxNum:
            maxNum = graph[i][j]

# DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def dfs(x, y, num):
    # 주어진 범위를 벗어나는 경우에는 즉시 종료
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False
    # 현재 노드를 아직 방문하지 않았다면
    if visited[x][y] == 0 and graph[x][y] > num:
        # 해당 노드 방문 처리
        visited[x][y] = 1
        # 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
        dfs(x - 1, y, num)
        dfs(x, y - 1, num)
        dfs(x + 1, y, num)
        dfs(x, y + 1, num)
        return True
    return False


# 모든 노드(위치)에 대하여 음료수 채우기
for num in range(maxNum):
    result = 0
    visited = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            # 현재 위치에서 DFS 수행
            if dfs(i, j, num) == True:
                result += 1
    safearea.append(result)

print(max(safearea))  # 정답 출력

# BFS
# from collections import deque
# n = int(input())
# graph = []
# maxNum = 0
# result = []
#
# dx = [0,0,-1,1]
# dy = [1,-1,0,0]
#
# for i in range(n):
#     graph.append(list(map(int, input().split())))
#     for j in range(n):
#         if graph[i][j] > maxNum:
#             maxNum = graph[i][j]
#
# def bfs(x, y, num):
#     queue = deque()
#     queue.append((x, y))
#     visited[x][y] = 1
#
#     while queue:
#         x, y = queue.popleft()
#
#         for i in range(4):
#             nx = dx[i] + x
#             ny = dy[i] + y
#
#             if nx >= 0 and nx < n and ny >= 0 and ny < n:
#                 if graph[nx][ny] > num and visited[nx][ny] == 0:
#                     visited[nx][ny] = 1
#                     queue.append((nx, ny))
#
# for i in range(maxNum):
#     cnt = 0
#     visited = [[0]*n for _ in range(n)]
#     for j in range(n):
#         for k in range(n):
#             if graph[j][k] > i and visited[j][k] == 0:
#                 bfs(j, k, i)
#                 cnt += 1
#     result.append(cnt)
#
# print(max(result))