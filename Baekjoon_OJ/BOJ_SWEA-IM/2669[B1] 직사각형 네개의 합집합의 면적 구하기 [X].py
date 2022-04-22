# x,y 평면 
board = [[0 for _ in range(101)] for _ in range(101)]

# x 시작, y시작, x끝, y끝 입력받고 해당 좌표 색칠
for _ in range(4):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(x1, x2):
        for j in range(y1, y2):
            board[i][j] = 1
result = 0   
         
# 색칠된 면적 구하기
for k in range(101):
    for l in range(101):
        if board[k][l] == 1:
            result += 1
            
print(result)

# 다른사람의 코드
check_cor=[]
for i in range(4):
    inp = list(map(int, input().split()))
    for i in range(inp[0], inp[2]):
        for j in range(inp[1], inp[3]):
            check_cor.append((i,j))

print(len(set(check_cor)))