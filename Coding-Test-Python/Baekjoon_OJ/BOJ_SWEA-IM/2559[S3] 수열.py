# 제출 답안
n, k = map(int, input().split())
num = list(map(int, input().split()))
sum_num = sum(num[:k])
result = sum_num
for i in range(k,n):
    sum_num += num[i] - num[i-k]
    result = max(sum_num, result)
print(result)

# 처음 시도한 답
# import sys
# from collections import deque
# input = sys.stdin.readline
# n, k = map(int,input().split())
# temp = list(map(int,input().split()))
# qtemp = deque([temp])
# seq_temp = deque([]) 
# for i in range(n+1-k):
#     result = 0
#     for j in range(0+i,k+i):
#         result += temp[j]
#     seq_temp.append(result)
# print(max(seq_temp))