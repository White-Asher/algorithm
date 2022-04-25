T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    if n == 1:
        num_list = [[1]]
    else:
        num_list = [[1],[1,1]]
        for i in range(2, n):
            t = [1]
            for j in range(1,i):
                t.append(num_list[i-1][j-1] + num_list[i-1][j])
            t.append(1)
            num_list.append(t)
    print("#{}".format(test_case))
    for i in num_list:
        print(*i)