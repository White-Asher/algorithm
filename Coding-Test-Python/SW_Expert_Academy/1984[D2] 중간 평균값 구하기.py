from collections import deque
t = int(input())
for tc in range(1, t+1):
    num = list(map(int, input().split()))
    num.sort()
    qnum = deque(num)
    qnum.pop()
    qnum.popleft()
    result = int(round(sum(qnum) / len(qnum), 0))
    print("#{} {}".format(tc, result))