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

# 제출 답안
n, k = map(int, input().split()) 
arr = list(map(int, input().split())) 
sum_arr = sum(arr[:k])
result = sum_arr
for i in range(k,n):
    sum_arr += arr[i] - arr[i-k]
    result = max(result, sum_arr)
print(result)

# 참고한 답
# N, K = map(int, input().split()) 
# arr = list(map(int, input().split())) 
# tmp = sum(arr[:K]) 
# result = tmp 
# for i in range(K, N): 
#     tmp += arr[i] - arr[i-K] 
#     result = max(result, tmp) 
# print(result)