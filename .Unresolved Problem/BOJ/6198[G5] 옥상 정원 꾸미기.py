n = int(input())
arr = [int(input()) for i in range(n)]
stk = []
result = 0

for i in range(n):
    while stk and stk[-1] <= arr[i]:
        stk.pop()
    stk.append(arr[i])
    result += len(stk) - 1

print(result)
# 풀이 참고 https://velog.io/@inhibitor/Problem-Solving-%EC%98%A5%EC%83%81-%EC%A0%95%EC%9B%90-%EA%BE%B8%EB%AF%B8%EA%B8%B0
# 풀이 참고2 https://lakelouise.tistory.com/62?category=1006962

# 빠른 실행 풀이
import sys
n=int(sys.stdin.readline())
stack=[]
cnt=0
for i in range(n):
    a=int(sys.stdin.readline())
    if stack==[]:
        stack.append(a)
    else:
        while stack[-1]<=a:
            stack.pop()
            if stack==[]:
                break
        cnt+=len(stack)
        stack.append(a)
print(cnt)

# 시간초과
# import sys
# input = sys.stdin.readline
# from collections import deque
#
# n = int(input())
# apart = deque(0 for _ in range(n))
# view = deque(0 for _ in range(n))
# for i in range(n):
#     apart[i] = (int(input()))
#
# def sol(i):
#     j = i+1
#
#     while j != len(apart):
#
#         if apart[i] < apart[j]:
#             view[i] = (j-i-1)
#             return
#         j += 1
#     view[i] = (j-i-1)
#
# for a in range(len(apart)-1):
#     sol(a)
#
# print(sum(view))