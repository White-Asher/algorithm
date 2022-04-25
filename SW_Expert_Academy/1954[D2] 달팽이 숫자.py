# 정답 답안
t = int(input())
# 우 하 좌 상
xl = [1,0,-1,0]
yl = [0,1,0,-1]

for tc in range(1, t+1):
    n = int(input())
    board = [[0 for _ in range(n)] for _ in range(n)]

    dist = 0
    y = 0
    x = 0
    
    for i in range(1, n*n+1):
        board[y][x] = i
        x += xl[dist]
        y += yl[dist]
        
        if y >= n or x >= n or y < 0 or x < 0 or board[y][x] != 0:
            x -= xl[dist]
            y -= yl[dist]
            
            dist = (dist+1)%4
    
            x += xl[dist]
            y += yl[dist]
    print("#{}".format(tc))
    for i in board:
        print(*i)
    print()
    
# 시도했던 답안 (실패)
'''
def change_dir(x,y,n,board,dir):
    if x > n-1 or y > n-1 or x < 0 or y < 0 or board[x][y] != 0:
        print("change_dir")
        if dir == 1:
            return 2
        elif dir == 2:
            return 3
        elif dir == 3:
            return 4
        elif dir == 4:
            return 1
    else:
        return dir

t = int(input())
for tc in range(t):
    n = int(input())
    board = [[0 for _ in range(n)] for _ in range(n)]
    count = 1
    dir = 1
    x = 0
    y = n-1
    while True:
        dir = change_dir(x,y,n,board,dir)
        print("x:",x)
        print("y:",y)
        print("dir:",dir)
        
        if dir == 1:
            print("check1")
            board[x][y] = count
            count += 1
            x += 1
        elif dir == 2:
            print("check2")
            board[x][y] = count
            count += 1
            y -= 1
        elif dir == 3:
            print("check3")
            board[x][y] = count
            count += 1
            x -= 1
        elif dir == 4:
            print("check4")
            board[x][y] = count
            count += 1
            y += 1
            
        if count > n*n:
            print("break")
            break
    
print(board)
'''