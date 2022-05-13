# 제출한답
import sys
input = sys.stdin.readline
n = int(input())
info = [0] * 1001
max_high = 0
max_high_index = 0
end_index = 0

for i in range(n):
    w, h = map(int, input().split())
    info[w] = h
    if max_high < h:
        max_high = h
        max_high_index = w
    end_index = max(end_index, w)

stack = []
area = 0

for i in range(0, max_high_index+1):
    if not stack:
        stack.append(info[i])
    else:
        if stack[-1] < info[i]:
            stack.append(info[i])
    area += stack[-1]

stack = []

for i in range(end_index, max_high_index, -1):
    if not stack:
        stack.append(info[i])
    else:
        if stack[-1] < info[i]:
            stack.append(info[i])
    area += stack[-1]

print(area)


# 시도한 것

n = int(input())
x_max, y_max = 0,0
stack = []
new_stack = []

for i in range(n):
    x,y = map(int,input().split())
    stack.append([x,y])
stack.sort()

y = [i[1] for i in stack]
y_max_index = y.index(max(y))
index = 0

result = stack[y_max_index][1]

while True:
    if stack[index][1] < stack[y_max_index][1]:
        if stack[index][1] > stack[index+1][1]:
            stack.pop(index+1)
            index -= 1
        else:
            result += (stack[index+1][0] - stack[index][0]) * stack[index][1]
    elif stack[index][1] == stack[y_max_index][1]:
        break
    index += 1

y = [i[1] for i in stack]
y_max_index = y.index(max(y))
index = len(stack) - 1

while True:
    if stack[index][1] < stack[y_max_index][1]:
        if stack[index][1] > stack[index-1][1]:
            stack.pop(index-1)
            index += 1
        else:
            result += (stack[index][0] - stack[index-1][0]) * stack[index][1]
    elif stack[index][1] == stack[y_max_index][1]:
        break
    index -= 1

print(result)

# 다른 풀이
import sys
input = sys.stdin.readline

n = int(input())
board = sorted([tuple(map(int,input().split())) for _ in range(n)])

last_idx, last_h = board[0]
result = 0
while(True):
    max_idx,max_h = 0,0
    # 현재 위치부터 큰 것이 나올 때까지 탐색
    for j in range(board.index((last_idx,last_h))+1,n):
        cur_idx,cur_h = board[j]
        if cur_h > last_h:
            result += (cur_idx-last_idx)*last_h
            last_idx,last_h = cur_idx,cur_h
            break
        if cur_h > max_h:
            max_idx,max_h = cur_idx,cur_h
    # 현재 위치보다 큰 것이 없다면 가장 컸던 것까지만 곱해주고 인덱스를 그곳으로 옮김
    else:
        result += last_h + (max_idx-last_idx-1)*max_h
        last_idx,last_h = max_idx,max_h
        if last_idx == 0:
            break
print(result)

# 또 다른 풀이
import sys
input = sys.stdin.readline

n = int(input())

rec = [0 for _ in range(1001)]
for _ in range(n):
    l, h = map(int, input().split())
    rec[l] = h
max_idx = rec.index(max(rec))

max_val = 0
for i in range(max_idx):
    max_val = max(max_val, rec[i])
    rec[i] = max_val

max_val = 0
for i in range(1000, max_idx, -1):
    max_val = max(max_val, rec[i])
    rec[i] = max_val

print(sum(rec))