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