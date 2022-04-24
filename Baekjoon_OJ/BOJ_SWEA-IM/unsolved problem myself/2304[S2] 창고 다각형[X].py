# 시도한 것

# n = int(input())
# x_max, y_max = 0,0
# stack = []
# new_stack = []

# for i in range(n):
#     x,y = map(int,input().split())
#     stack.append([x,y])
# stack.sort()

# y = [i[1] for i in stack]
# y_max_index = y.index(max(y))
# index = 0

# result = stack[y_max_index][1]

# while True:
#     if stack[index][1] < stack[y_max_index][1]:
#         if stack[index][1] > stack[index+1][1]:
#             stack.pop(index+1)
#             index -= 1
#         else:
#             result += (stack[index+1][0] - stack[index][0]) * stack[index][1]
#     elif stack[index][1] == stack[y_max_index][1]:
#         break
#     index += 1

# y = [i[1] for i in stack]
# y_max_index = y.index(max(y))
# index = len(stack) - 1

# while True:
#     if stack[index][1] < stack[y_max_index][1]:
#         if stack[index][1] > stack[index-1][1]:
#             stack.pop(index-1)
#             index += 1
#         else:
#             result += (stack[index][0] - stack[index-1][0]) * stack[index][1]
#     elif stack[index][1] == stack[y_max_index][1]:
#         break
#     index -= 1

# print(result)

# 다른 풀이
# import sys
# input = sys.stdin.readline

# n = int(input())
# board = sorted([tuple(map(int,input().split())) for _ in range(n)])

# last_idx, last_h = board[0]
# result = 0
# while(True):
#     max_idx,max_h = 0,0
#     # 현재 위치부터 큰 것이 나올 때까지 탐색
#     for j in range(board.index((last_idx,last_h))+1,n):
#         cur_idx,cur_h = board[j]
#         if cur_h > last_h:
#             result += (cur_idx-last_idx)*last_h
#             last_idx,last_h = cur_idx,cur_h
#             break
#         if cur_h > max_h:
#             max_idx,max_h = cur_idx,cur_h
#     # 현재 위치보다 큰 것이 없다면 가장 컸던 것까지만 곱해주고 인덱스를 그곳으로 옮김
#     else:
#         result += last_h + (max_idx-last_idx-1)*max_h
#         last_idx,last_h = max_idx,max_h
#         if last_idx == 0:
#             break
# print(result)

# 또 다른 풀이
N = int(input())

info = [0] * 1001
max_height = 0  # 최대 높이
max_height_index = 0  # 최대 높이의 인덱스
end_index = 0  # 끝 인덱스
for i in range(N):
    w, h = map(int, input().split())  # 가로와 높이를 입력받는다.
    info[w] = h  # 가로를 인덱스로 높이를 그 인덱스의 값으로 설정한다.
    if max_height < h:  # 만약 높이가 현재 저장된 최대 높이보다 크다면
        max_height = h  # 그 높이를 최대높이로 지정하고
        max_height_index = w  # 그 인덱스를 저장해 놓는다.
    end_index = max(end_index, w)  # 가장 큰 인덱스를 구한다.

stack = []  # 빈 스택 선언
result = 0  # 총 넓이
for i in range(0, max_height_index + 1):  # 최대높이의 인덱스까지 반복문을 돈다.

    if not stack:  # 만약 스택이 비어있다면
        stack.append(info[i])  # 스택에 처음 넓이값을 추가해준다.
    else:  # 비어있지 않다면
        if stack[-1] < info[i]:  # 만약 스택에 있는 값보다 높이가 크다면
            stack.pop()  # 존재하는 스택값 빼고
            stack.append(info[i])  # 새로운 값을 넣어준다.
    result += stack[-1]  # 계속해서 스택의 값을 결과값에 넣어준다.

stack = []  # 빈 스택 선언
for j in range(end_index, max_height_index, -1):  # 마지막 인덱스부터 최대 높이 인덱스 전까지 반대로 돈다.

    if not stack:  # 스택이 비어있다면
        stack.append(info[j])  # 초기 맨 마지막 인덱스의 높이 값을 추가해준다.

    else:  # 스택이 비어있지 않다면
        if stack[-1] < info[j]:  # 만약 더 높은 높이 값이 나왔다면
            stack.pop()  # 그 값을 빼고
            stack.append(info[j])  # 새로운 높이 값을 스택에 넣어준다.
    result += stack[-1]  # 계속해서 스택에 있는 넓이값을 더해준다.

print(result)  # 결과값 출력