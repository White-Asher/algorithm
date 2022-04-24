# 내가 시도한 것 (오답)
bingo = [list(map(int, input().split())) for _ in range(5)]
cal_num = [list(map(int, input().split())) for _ in range(5)]
checked = [[0 for _ in range(5) ] for _ in range(5)]
            
def checking():
    result = 0
    
    for x in range(5):
        if checked[x].count(1) == 5:
            result += 1
            if result >= 3:
                return result
            
        y_check = 0
        for y in range(5):
            if checked[x][y] == 1:
                y_check += 1
            if y_check == 5:
                result += 1
                if result >= 3:
                    return result

    xy_check = 0
    for x1 in range(5):
        for y1 in range(5):
            if checked[x1][y1] == 1:
                xy_check += 1
                if xy_check == 5:
                    result += 1
                    if result >= 3:
                        return result
    return result
                
def loop():
    for i in range(5):
        for j in range(5):
            for a in range(5):
                for b in range(5):
                    if cal_num[i][j] == bingo[a][b]:
                        checked[a][b] = 1
                        if checking() >= 3:
                            return (i+1)*(j+1)
                        
print(loop())

#다른 사람 풀이 1
import sys
input = sys.stdin.readline

# 숫자들의 위치 기록
board = dict()
check = [[0]*5 for i in range(5)]
for i in range(5):
    a = list(map(int,input().split()))
    for j in range(5):
        board[a[j]] = (i,j)

tick = 0
for _ in range(5):
    a = list(map(int,input().split()))
    for i in range(5):
        tick += 1
        
        # 불린 숫자가 보드에 있을 경우
        if a[i] in board:
            # 딕셔너리를 이용해 기록
            check[board[a[i]][0]][board[a[i]][1]] = 1
            
            # 빙고 세주기
            bingo = 0
            for j in range(5):
                if sum(check[j]) == 5:
                    bingo+=1
                if sum([k[j] for k in check]) == 5:
                    bingo+=1
            if check[0][4]+check[1][3]+check[2][2]+check[3][1]+check[4][0] == 5:
                bingo+=1
            if check[0][0]+check[1][1]+check[2][2]+check[3][3]+check[4][4] == 5:
                bingo+=1
                
            if bingo >= 3:
                print(tick)
                sys.exit()
                
# 다른 사람 풀이 2
n = 5
arr = [list(map(int, input().split())) for _ in range(n)]
 
MC = []
for _ in range(5):
    MC += list(map(int, input().split()))
 
bingo, order = 0, 0
check_row, check_column, check_diagonal = [False] * n, [False] * n, [False] * 2
 
def check(arr):
    global bingo, check_diagonal
    temp_right, temp_reverse = 0, 0
 
    for i in range(n):
        if str(arr[i]).count('[0, 0, 0, 0, 0]') and not check_row[i]:  # check row
            bingo += 1
            check_row[i] = True
 
        temp_column = list(map(lambda x: x[i], arr))  # check column
        if str(temp_column).count('[0, 0, 0, 0, 0]') and not check_column[i]:
            bingo += 1
            check_column[i] = True
 
        temp_right += arr[i][i]    # check diagonal
        temp_reverse += arr[i][n - i - 1]
 
    if not temp_right and not check_diagonal[0]:
        check_diagonal[0] = True
        bingo += 1
 
    if not temp_reverse and not check_diagonal[1]:
        check_diagonal[1] = True
        bingo += 1
 
    return bingo
 
for target in range(25):
    for i in range(5):
        for j in range(5):
            if MC[target] == arr[i][j]:
                arr[i][j] = 0
                check(arr)
                order += 1
                if bingo >= 3:
                    print(order)
                    exit()