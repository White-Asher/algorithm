t = int(input())
for tc in range(1, t+1):
    num = list(map(int, input().split()))
    if num[0] == num[1]:
        result = num[2]
    elif num[1] == num[2]:
        result = num[0]
    elif num[0] == num[2]:
        result = num[1]
    print("#{} {}".format(tc, result))