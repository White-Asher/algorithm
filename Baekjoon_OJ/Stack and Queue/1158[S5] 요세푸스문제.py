person, num = map(int,input().split())
entire_list = []
result = []
popNum = 0
for i in range(person):
    entire_list.append(i+1)

while len(entire_list) > 0 :
    popNum = (popNum + (num-1)) % len(entire_list)
    popElement = entire_list.pop(popNum)
    result.append(str(popElement))

print("<%s>" %(", ".join(result)))

# deque rotate 를 사용하는 문제 (타 블로그 참고)
# import sys
# input = sys.stdin.readline
# from collections import deque
# N, K = map(int, input().split())
# dq = deque([i for i in range(1, N+1)])
# res = []
# while dq:
#     dq.rotate(-K+1)
#     res.append(str(dq.popleft()))
#
# sys.stdout.write("<"+", ".join(res)+">")