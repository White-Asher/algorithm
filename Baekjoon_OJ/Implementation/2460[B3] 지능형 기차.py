max = 0
curr = 0
for i in range(10):
    a,b = map(int,input().split())
    curr = curr - a
    curr = curr + b
    if(max < curr):
        max = curr
print(max)

# 다른사람 풀이
import sys
N=[0]
for _ in range(1,10) :
    A,B=map(int,sys.stdin.readline().rsplit())
    N.append(N[_-1]+B-A)
print(max(N))