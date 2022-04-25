# 제출 답안 (정답)

c,r = map(int,input().split())
t = int(input())

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
board = [[0 for _ in range(c)] for _ in range(r)]
dire = 0
x = 0
y = r-1

if t > c*r:
    print(0)
    exit()
else:
    for i in range(1,t+1):
        board[y][x] = i
        if i == t:
            print(x+1,r-y)
            break
        x += dx[dire]
        y += dy[dire]
        
        if x >= c or y >=r or x < 0 or y < 0 or board[y][x] != 0:
            x -= dx[dire]
            y -= dy[dire]
            
            dire = (dire + 1) % 4
            
            x += dx[dire]
            y += dy[dire]


# 다른 답안

# C,R = map(int,input().split())
# my_seat = int(input())

# #좌석을 줄 수 없는 경우 
# if my_seat > C*R :
#     print(0)
#     exit()

# #4방향 
# dx = [0,1,0,-1]
# dy = [-1,0,1,0]

# #그리드 만들기 
# grid = [[0]*C for _ in range(R)]
# direct = x = y = 0

# #행렬 돌면서 
# for seat in range(1, C*R+1):
#     #내자리면 끝내기 
#     if seat == my_seat:
#         print(y+1,x+1)
#         break
    
#     else :
#         # 앉았다는 것을 표시함.
#         grid[x][y] = seat
#         #앞으로 전진 
#         x += dx[direct]
#         y += dy[direct]

#         if x < 0 or y < 0 or x >= R or y >= C or grid[x][y]:
#             x -= dx[direct]
#             y -= dy[direct]
#             #범위 벗어나면 뒤로 뺐다가 방향 바꿔서 전진 
#             direct = (direct+1)%4
#             x += dx[direct]
#             y += dy[direct]


# 시도했던 답안(X)
'''
x,y = map(int,input().split())
k = int(input())
visited = [[0 for _ in range(x)] for _ in range(y)]
count = 1
visited[0][0] = 1
a = 0
b = 0

def visited_check(count):
    if visited[a][b] == 0:
        visited[a][b] = 1
        count += 1
        print("def count", count)
    elif visited[a][b] == 1:
        i += 1

i = 0
while k != count:
    print("count", count)
    print("k", k)
    print("a", a)
    print("b", b)
    print("i", i)
    
    if i == 0:
        print("icheck1")
        if 0 <= a and a < x and 0 <= b and b < y:
            
            b += 1
            visited_check(count)
            print("icheck2")
        else:
            print("icheck3")
            i = 1
        
    elif i == 1:
        if 0 <= a and a < x and 0 <= b and b < y:
            a += 1
            visited_check(count)
        else:
            i = 2
    
    elif i == 2:
        if 0 <= a and a < x and 0 <= b and b < y:
            b -= 1
            visited_check(count)
        else:
            i = 3
    
    elif i == 3:
        if 0 <= a and a < x and 0 <= b and b < y:
            a -= 1
            visited_check(count)
        else:
            i = 0
    
    if count > x*y:
        count = 0
        break
    
print(count)
'''