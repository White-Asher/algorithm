T = int(input())
for test_case in range(1, T + 1):
    a = list(map(int,input().split()))
    print("#{} {}".format(test_case,round(sum(a)/len(a))))