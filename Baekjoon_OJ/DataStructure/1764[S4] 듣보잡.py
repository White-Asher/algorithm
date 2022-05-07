import sys
input = sys.stdin.readline

n, m = map(int, input().split())
d = set()
result = set()

for i in range(n):
    d.add(input())

for j in range(m):
    temp = input()
    if temp in d:
        result.add(temp)

print(len(result))
print("".join(sorted(result)))