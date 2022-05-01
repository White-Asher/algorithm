# 제출 답안 
m = int(input())
n = int(input())
li = []

for i in range(m,n+1):
    count = 0
    for j in range(1,i+1):
        if i % j == 0:
            count += 1
    if count == 2:
        li.append(i)
        
if len(li) == 0:
    print(-1)
else:
    print(sum(li))
    print(min(li))
    
# 실행시간이 훨씬 작은것 
import math

a = int(input())
b = int(input())

cnt = 0
for i in range(a, b + 1):
    flag = i
    k = i
    for j in range(2, math.floor(math.sqrt(k)) + 1):
        if k % j == 0:
            flag = 1
            break
    if flag != 1:
        if cnt == 0:
            m = i
        cnt += i

if cnt == 0:
    print(-1)
else:
    print(cnt)
    print(m)