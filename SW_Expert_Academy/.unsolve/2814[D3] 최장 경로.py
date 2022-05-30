def dfs(idx,cnt):
    global maxVal
    visit[idx] = True
    if cnt > maxVal:
        maxVal = cnt
    for i in s[idx]:
        if not visit[i]:
            dfs(i,cnt+1)
            visit[i] = 0

t = int(input())
for tc in range(1, t+1):
    n,m = map(int,input().split())
    s=[[] for i in range(n+1)]
    for i in range(m):
        x,y = map(int,input().split())
        s[x].append(y)
        s[y].append(x)
    maxVal = 0

    for i in range(1,n+1):
        visit = [0] * (n+1)
        dfs(i,1)
    print('#%d %d' % (tc, maxVal))