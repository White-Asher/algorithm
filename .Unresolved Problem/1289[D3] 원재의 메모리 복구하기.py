# 참고한 답
T = int(input())

for test_case in range(1, T + 1):
    count = 0
    flag = "0"
    num = input()

    for j in range(len(num)):
        if num[j] != flag:
            count += 1
            flag = num[j]

    print("#{} {}".format(test_case, count))

# 시도한 답 (오답)
from collections import deque
t = int(input())
for tc in range(1, t+1):
    num = list(map(int, input()))
    dnum = deque(num)

    result = 0

    while len(dnum):
        q = dnum[0]
        if q == 0:
            dnum.popleft()
        else:
            break

    while len(dnum):
        q = dnum[0]

        if q == 0:
            dnum.popleft()
            if len(dnum) == 0:
                break
            if dnum[1] == 1:
                result += 1

        elif q == 1:
            dnum.popleft()
            if len(dnum) == 0:
                break
            if dnum[1] == 0:
                result += 1

    print("#{} {}".format(tc, result))
