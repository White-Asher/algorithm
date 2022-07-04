N = int(input())
for i in range(N):
    input_data = input()
    list_data = []

    for j in input_data:
        if j == "(":
            list_data.append(j)
        elif j == ")":
            if len(list_data) != 0 and list_data[-1] == '(':
                list_data.pop()
            else:
                list_data.append(")")
                break
    if len(list_data) == 0:
        print('YES')
    else:
        print('NO')