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
input = sys.stdin.readline

n,m = map(int, input().split())
li = list(map(int, input().split()))

sum_list = [0]
summ = 0

for i in li:
    summ += i
    sum_list.append(summ)

for j in range(m):
    a,b = map(int, input().split())
    print(sum_list[b] - sum_list[a-1])