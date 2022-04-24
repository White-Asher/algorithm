# 다른 답안
# 1. 두 직사각형의 왼변중 x 좌표가 큰 변, 오른변중 x 좌표가 작은 변, 윗변중 y 좌표가 작은 변, 아랫변중 y 좌표가 큰 변을 고른다.

# 2. 위에서 구한 값 중 x 축에 평행한 변의 좌표끼리, y 축에 평행한 변의 좌표끼리 서로 빼준다.(각각 xdiff, ydiff)

# 3. xdiff 나 ydiff 둘다 0이상이면 a 
#     둘중 하나라도 0 이하면 d
#     둘다 0이면 c
#     나머지는 b

# 4. 위 과정을 4번 반복한다.

for i in range(4):
    x1, y1, p1, q1, x2, y2, p2, q2 = map(int, input().split())

    # 1번 과정
    xl = max(x1, x2)
    xr = min(p1, p2)
    yb = max(y1, y2)
    yt = min(q1, q2)

    # 2번 과정
    xdiff = xr - xl
    ydiff = yt - yb
    
    # 3번 과정
    if xdiff > 0 and ydiff > 0:
        print('a')
    elif xdiff < 0 or ydiff < 0:
        print('d')
    elif xdiff == 0 and ydiff == 0:
        print('c')
    else:
        print('b')

# 또 다른 답안
import sys
input = sys.stdin.readline

for _ in range(4):
    x1,y1,p1,q1,x2,y2,p2,q2 = map(int, input().split())
    if p1 < x2 or p2 < x1 or y1 > q2 or q1 < y2:
        print('d')
        continue
    elif x1==p2 or x2==p1:
        if q1==y2 or q2==y1:
            print('c')
            continue
        else:
            print('b')
            continue
    elif q1==y2 or q2==y1:
            print('b')
            continue
    else:
        print('a')
        continue
    
# 제출답안 시간초과 (오답)
x1,y1,p1,q1, x2,y2,p2,q2 = map(int,input().split())
board = [[0 for _ in range(10000)] for _ in range(10000)]

def a_check():
    area = (p1-x1)*(q1-y1)
    for i in range(x1,p1):
        for j in range(y1,q1):
            board[i][j] = 1
    for i in range(x2,p2):
        for j in range(y2,q2):
            board[i][j] = 2
    temp_board = sum(board, [])
    if temp_board.count(i) != area:
        return True

def b_check():
    if (x1<x2 and x2<p1)or(x1<p2 and p2<p1)or(x2<x1 and x1<p2)or(x2<p1 and p1<p2):
        return True
    elif (y1<y2 and y2<q1)or(y1<q2 and q2<q1)or(y2<y1 and y1<q2)or(y2<q1 and q1<q2):
        return True

def c_check():
    if(x1==p2 and q1==y2)or(p1==x2 and q1==y2)or(x1==p2 and y1==q2)or(p1==x2 and y1==q2):
        return True

for i in range(4):
    if a_check() == True:
        print('a')
    elif b_check() == True:
        print('b')
    elif c_check() == True:
        print('c')
    else:
        print('d')
        