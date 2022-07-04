from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    queue = deque([start])
    visited = set()
    while queue:
        x,y = queue.popleft()
        if abs(x - dest[0]) + abs(y - dest[1]) <= 1000:
            return True
        for i in range(n):
            if i not in visited:
                nx, ny = cs[i]
                if abs(x - nx) + abs(y - ny) <= 1000:
                    queue.append([nx, ny])
                    visited.add(i)
    return False

t = int(input())

for _ in range(t):
    n = int(input())
    start = list(map(int, input().split()))
    cs = [list(map(int, input().split())) for _ in range(n)]
    dest = list(map(int, input().split()))
    if bfs():
        print("happy")
    else:
        print("sad")
