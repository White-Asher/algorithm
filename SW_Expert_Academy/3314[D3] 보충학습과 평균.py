T = int(input())
for test_case in range(1, T + 1):
    li = list(map(int, input().split()))
    lli = len(li)
    for i in range(lli):
        if li[i] < 40:
            li[i] = 40

    print("#{} {}".format(test_case, sum(li)//lli))