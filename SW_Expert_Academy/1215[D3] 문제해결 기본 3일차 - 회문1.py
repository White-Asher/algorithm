n = int(input())
for tc in range(1, 11):
    str_list = [list(map(int, input())) for _ in range(8)]
    for i in range(0,8):
        for j in range(n - 1, 8 - n):
            temp = []
            temp.append(str_list[i][j])

    for i in range(0, 8):
        for j in range(n - 1, 8 - n):

