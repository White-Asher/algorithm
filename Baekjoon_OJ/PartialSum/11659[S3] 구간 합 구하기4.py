import sys
input = sys.stdin.readline

n, m = map(int, input().split())
num_list = list(map(int, input().split()))

sum_list = [0] * (n+1)
sum_list[1] = num_list[0]

for i in range(2, n+1):
    sum_list[i] = sum_list[i-1] + num_list[i-1]

for i in range(m):
    a, b = map(int, input().split())
    print(sum_list[b] - sum_list[a - 1])

# 다른 답안
import sys
N, M = map(int, sys.stdin.readline().split())
lst = list(map(int, sys.stdin.readline().split()))
sum_lst = [0]
hap = 0
for i in lst:
    hap += i
    sum_lst.append(hap)
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    print(sum_lst[b]-sum_lst[a-1])