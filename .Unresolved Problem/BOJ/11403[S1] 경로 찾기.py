from collections import deque

n = int(input())

graph =[[]]
for _ in range(n):
    graph.append(list(map(int, str(input().rstrip()))))

visited = [False] * (n+1)

def bfs(x):
    queue = deque([x])
    visited[x] = True

    while queue:
        q = queue.popleft()

        for i in graph[q]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
