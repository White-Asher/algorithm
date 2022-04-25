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
    if dir == 1:
        dir = change_dir(x,y,n,board,dir)
        board[x][y] = count
        count += 1
        x += 1
    elif dir == 2:
        dir = change_dir(x,y,n,board,dir)
        board[x][y] = count
        count += 1
        y -= 1
    elif dir == 3:
        dir = change_dir(x,y,n,board,dir)
        board[x][y] = count
        count += 1
        x -= 1
    elif dir == 4:
        dir = change_dir(x,y,n,board,dir)
        board[x][y] = count
        count += 1
        y += 1
    print(dir)
    if count > n*n:
        break
    
print(board)