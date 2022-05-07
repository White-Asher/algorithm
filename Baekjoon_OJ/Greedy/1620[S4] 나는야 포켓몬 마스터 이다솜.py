# 왜 시간초과?
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
poke = {}
for i in range(n):
    key = i + 1
    value = input().rstrip()
    poke[key] = value

for i in range(m):
    quest = input().rstrip()
    if quest.isdigit():
        for key, value in poke.items():
            if key == int(quest):
                print(value)
    else:
        for key, value in poke.items():
            if str(value) == str(quest):
                print(int(key))

# 왜 애는 통과가 될까?
import sys
input = sys.stdin.readline
n, m = map(int, input().split())

dict = {}
for i in range(1, n + 1):
    a = input().rstrip()
    dict[i] = a
    dict[a] = i

for i in range(m):
    quest = input().rstrip()
    if quest.isdigit():
        print(dict[int(quest)])
    else:
        print(dict[quest])