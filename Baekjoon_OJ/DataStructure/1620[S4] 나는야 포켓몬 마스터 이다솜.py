# 시간초과(오답)
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
        for key, value in poke.items(): # 문제의 코드
            if key == int(quest):
                print(value)
    else:
        for key, value in poke.items(): # 문제의 코드
            if str(value) == str(quest):
                print(int(key))

# 통과
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