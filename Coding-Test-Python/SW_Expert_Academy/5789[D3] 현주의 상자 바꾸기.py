T = int(input())
for test_case in range(1, T + 1):
    n, q = map(int, input().split())
    numlist = [0]*n
    for i in range(1, q+1):
        a,b = map(int, input().split())
        for j in range(a-1,b):
            numlist[j] = i

    print("#{}".format(test_case), end= ' ')
    print(*numlist)
