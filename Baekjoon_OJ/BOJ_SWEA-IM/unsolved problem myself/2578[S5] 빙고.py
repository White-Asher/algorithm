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

# 위 코드는 아닌것 같다. 