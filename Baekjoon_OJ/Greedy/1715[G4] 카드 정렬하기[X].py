import sys
import heapq

n = int(sys.stdin.readline())
card = []
answer = 0
for _ in range(n):
    heapq.heappush(card, int(sys.stdin.readline()))

if len(card) == 1:
    print(0)
    
else:
    while len(card) > 1:
        left = heapq.heappop(card)
        right = heapq.heappop(card)
        heapq.heappush(card, left+right)
        answer = answer + (left+right)
    print(answer)