board = [ [0 for _ in range(101)] for _ in range(101) ]
for i in range(int(input())):
    x,y = map(int,input().split())
    for a in range(10):
        for b in range(10):
            board[x+a][y+b] = 1
answer = sum(board, [])
print(answer.count(1))