import math

n,k  = map(int,input().split())
man = []
women = []
room_count = 0

for i in range(n):
    gender, grade = map(int,input().split())
    if gender == 0:
        women.append(grade)
    else:
        man.append(grade)

for i in range(1,7):
    if i in women:
        wrc = women.count(i)
        room = math.ceil(wrc/k)
        room_count += room
    
    if i in man:
        mrc = man.count(i)
        room = math.ceil(mrc/k)
        room_count += room
        
print(room_count)

# 다른 사람의 답안
import sys,math
input = sys.stdin.readline

n,k = map(int,input().split())
arr = [[[],[]] for _ in range(7)]
for _ in range(n):
    s,y = map(int,input().split())
    arr[y][s].append(1)

ans = 0
for w,m in arr:
    ans += math.ceil(len(w)/k) + math.ceil(len(m)/k)
print(ans)