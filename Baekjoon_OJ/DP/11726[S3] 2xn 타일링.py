# import sys
# input = sys.stdin.readline
#
# n = int(input())
# arr = [0] * (1001)
# arr[1] = 1
# arr[2] = 2
#
# if n >= 3:
#     for i in range(3, n+1):
#         arr[i] = arr[i-1] + arr[i-2]
#
# print(int(arr[n]%10007))

# 더 짧은 답
n = int(input())

d=[0]*1001

d[1]=1
d[2]=2

for i in range(3,n+1):
    d[i]=(d[i-1]+d[i-2])

print(d[n]%10007)

#오답(재귀오류발생)
# import sys
# input = sys.stdin.readline
#
# def dp(x):
#     if x == 1:
#         return 1
#     elif x == 2:
#         return 2
#     else:
#         return dp(x-1) + dp(x-2)
# result = dp(int(input()))
# print(result)
# print(result % 10007)