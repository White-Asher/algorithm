# import sys
# input = sys.stdin.readline
# import heapq
# card = []
# result = 0
# for _ in range(int(input())):
#     heapq.heappush(card, int(input()))
# if len(card) == 1:
#     print(0)
# else:
#     while len(card) != 1:
#         left = heapq.heappop(card)
#         right = heapq.heappop(card)
#         heapq.heappush(card, left + right)
#         result += left + right
#     print(result)

import sys
input = sys.stdin.readline
import heapq
card = []
result = 0
for _ in range(int(input())):
    heapq.heappush(card, int(input()))
if len(card) == 1:
    print(0)
else:
    while len(card) != 1:
        lr = heapq.heappop(card) + heapq.heappop(card)
        heapq.heappush(card, lr)
        result += lr
    print(result)
