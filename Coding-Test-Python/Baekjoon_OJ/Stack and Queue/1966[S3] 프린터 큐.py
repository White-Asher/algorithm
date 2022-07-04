from collections import deque
t = int(input())
for tc in range(t):
    n, m = map(int, input().split())
    printer = list(map(int, input().split()))
    printerQueue = deque(printer)

    indexQueue = deque()
    for i in range(n):
        indexQueue.append(i)
    cnt = 0

    while printerQueue:
        if printerQueue[0] == max(printerQueue):
            cnt += 1
            printerQueue.popleft()
            if indexQueue.popleft() == m:
                print(cnt)
                break
        else:
            printerQueue.append(printerQueue.popleft())
            indexQueue.append(indexQueue.popleft())