from collections import deque

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()
    
visited = []

def bfs(graph, start, visited):
    queue = deque([start])
    while queue:
        v = queue.popleft()
        
        for j in graph[v]:
            if j not in visited:
                visited.append(j)
                queue.append(j)
                
    return len(visited)-1

print(bfs(graph, 1,visited))

# 실행시간이 짧은 답안
# list를 쓰는 것보다 사전 자료형을 쓰는것이 시간복잡도가 더 좋음
from sys import stdin
read = stdin.readline
dic={}
for i in range(int(read())):
    dic[i+1] = set()
for j in range(int(read())):
    a, b = map(int,read().split())
    dic[a].add(b)
    dic[b].add(a)

def dfs(start, dic):
    for i in dic[start]:
        if i not in visited:
            visited.append(i)
            dfs(i, dic)
visited = []
dfs(1, dic)
print(len(visited)-1)

# BFS
from sys import stdin
read = stdin.readline
dic={}
for i in range(int(read())):
    dic[i+1] = set()
for j in range(int(read())):
    a, b = map(int,read().split())
    dic[a].add(b)
    dic[b].add(a)

def bfs(start, dic):
    queue = [start]
    while queue:
        for i in dic[queue.pop()]:
            if i not in visited:
                visited.append(i)
                queue.append(i)
visited = []
bfs(1, dic)
print(len(visited)-1)