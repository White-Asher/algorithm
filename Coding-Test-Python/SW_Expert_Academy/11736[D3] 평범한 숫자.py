T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    num = list(map(int, input().split()))
    cnt = 0
    for i in range(1, len(num)-1):
        if (num[i-1] <num[i] < num[i+1]) or (num[i-1] >num[i] > num[i+1]):
            cnt += 1
    print("#{} {}".format(test_case,cnt))