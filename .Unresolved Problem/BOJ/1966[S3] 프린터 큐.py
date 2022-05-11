from collections import deque

t = int(input())

for i in range(t):
    n, m = map(int, input().split())
    print_list = list(map(int, input().split()))
    queue = deque(print_list)

    idx_queue = deque(list(range(n)))
    cnt = 0
    while queue:
        if queue[0] == max(queue):
            cnt += 1
            queue.popleft()
            if idx_queue.popleft() == m:
                print(cnt)
        else:
            queue.append(queue.popleft())
            idx_queue.append(idx_queue.popleft())