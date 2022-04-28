# 제출답안
T = int(input())
for test_case in range(1, T + 1):
    matrix = [list(map(int,input().split())) for i in range(9)]
    result = 1
    for i in range(9):
        
        new_matrix1 = set([])
        for j in range(9):
            new_matrix1.add(matrix[i][j])
        if len(new_matrix1) != 9 :
            result = 0

        new_matrix2 = set([])
        for j in range(9):
            new_matrix2.add(matrix[j][i])
        if len(new_matrix2) != 9:
            result = 0
    
    if result:
        for col in range(0, 9, 3):
            for row in range(0, 9, 3):
                block_matrix = set([])
                for j in range(3):
                    for k in range(3):
                        block_matrix.add(matrix[col+j][row+k])
                if len(block_matrix) != 9:
                    result = 0
                    break
    
    print("#{} {}".format(test_case,result))
    
# 다른 답안
case_count = int(input())

for i in range(1, case_count + 1):
    matrix = [list(map(int, input().split())) for _ in range(9)]
    result = 1
    # 가로세로
    for row_index, row in enumerate(matrix):
        as_col = []
        if len({*row}) != 9:
            result = 0
            break
        else:
            for col in range(9):
                as_col.append(matrix[col][row_index])
            if len({*as_col}) != 9:
                result = 0
                break

    # 블록
    if result:
        for col in range(0, 9, 3):
            for row in range(0, 9, 3):
                block_numbers = []
                for j in range(3):
                    for k in range(3):
                        block_numbers.append(matrix[col+j][row+k])
                if len({*block_numbers}) != 9:
                    result = 0
                    break
    print('#{} {}'.format(i, result))
    
# 또 다른 답안
for idx in range(1, t+1): 
    # 스도쿠 판 받아와서 만들기 
    board = [] 
    for _ in range(9): 
        board.append(list(map(int, input().split()))) 
    
    answer = 1 
    
    # 3 * 3 작은 격자 9개 만들기 
    square = [[[] for _ in range(3)] for _ in range(3)] 
    for i in range(9): 
        garo = [] 
        # 가로 줄 
        sero = [] 
        # # 세로 줄 
        for j in range(9): 
            # 만약 검토하려는 숫자가 이미 가로 또는 세로 도는 작은 격자 안에 있다면 0. 바로 중단 
            if (board[i][j] in garo) or (board[j][i] in sero) or (board[i][j] in square[i//3][j//3]): 
                answer = 0 
                break 
            
            # 검토할 숫자가 가로 또는 세로 또는 작은 격자에 없다면 (겹치는게 아니라면) 추가 
            
            garo.append(board[i][j]) 
            sero.append(board[j][i]) 
            square[i//3][j//3].append(board[i][j]) 
            
            # 이미 겹치는 숫자가 있었다면 중단 
        
        if not answer: 
            break 
    
    print('#{} {}'.format(idx, answer))

