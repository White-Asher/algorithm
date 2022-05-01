# 제출답안
n = int(input())
dice = [list(map(int, input().split())) for _ in range(n)]
rotate = {0 : 5, 1 : 3, 2 : 4, 3 : 1, 4 : 2, 5 : 0}
sum_result = []

for i in range(6):
    max_side_list = []
    bottom_dice = [1,2,3,4,5,6]
    underside = dice[0][i]
    upperside = dice[0][rotate[i]]
    
    bottom_dice.remove(underside)
    bottom_dice.remove(upperside)
    
    max_side_list.append(max(bottom_dice))
    
    for j in range(1,n):
        next_dice = [1,2,3,4,5,6]
        underside = upperside
        upperside = dice[j][rotate[dice[j].index(upperside)]]
        
        next_dice.remove(underside)
        next_dice.remove(upperside)

        max_side_list.append(max(next_dice))
        
    sum_result.append(sum(max_side_list))
    
print(max(sum_result))