import sys
input = sys.stdin.readline

n = int(input())
a,b = map(int,input().split())
m = int(input())

graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
result = [0] * (n+1)

for i in range(m):
    x, y = map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)
    
    
def bfs(start):
    queue = [start]
    visited[start] = True
    
    while queue:
        v = queue.pop()
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                result[i] = result[v] + 1
    
bfs(a)
if result[b] > 0:
    print(result[b])
else:
    print(-1)

# deque 사용
from collections import deque

n = int(input())
a, b = map(int, input().split())

graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
result = [0] * (n+1)

for i in range(int(input())):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

def bfs(x):
    queue = deque()
    queue.append(x)
    visited[x] = True

    while queue:
        q = queue.popleft()
        for i in graph[q]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                result[i] = result[q] + 1

bfs(a)

if result[b] > 0:
    print(result[b])
else:
    print(-1)