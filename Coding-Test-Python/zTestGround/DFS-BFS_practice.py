from collections import deque

n, m, v = map(int,input().split())
graph = [[] for i in range(n+1)]

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()
    
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')
    for j in graph[v]:
        if not visited[j]:
            dfs(graph, j, visited)

def bfs(graph,visited,started):
    queue = deque([started])
    visited[started] = True
    
    while queue:
        v = queue.popleft()
        print(v, end= ' ')
        for k in graph[v]:
            if not visited[k]:
                queue.append(k)
                visited[k] = True

visited = [False] * (n+1)
dfs(graph, v, visited)
print("")
visited = [False] * (n+1)
bfs(graph, visited, v)