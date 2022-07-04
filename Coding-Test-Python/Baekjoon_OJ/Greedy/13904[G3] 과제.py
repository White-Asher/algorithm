import sys
input = sys.stdin.readline
n = int(input())
hw = [list(map(int, input().split())) for _ in range(n)]
hw.sort()
canHW = []
result = 0
for date in range(n, 0,-1):
    while hw and hw[-1][0] >= date:
        canHW.append(hw.pop()[1])
    if canHW:
        canHW.sort()
        result += canHW.pop()
print(result)