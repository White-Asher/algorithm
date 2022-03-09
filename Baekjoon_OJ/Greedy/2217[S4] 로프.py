from collections import deque
# from unicodedata import name
n = int(input())
# rope = deque()
for i in range(n):
    # rope.append(int(input()))
    a = int(input())
    if temp_min >= a:
        temp_min = a

print(temp_min*n)