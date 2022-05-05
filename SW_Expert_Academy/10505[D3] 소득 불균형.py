t = int(input())
for tc in range(1, t+1):
    n = int(input())
    money = list(map(int, input().split()))
    avg = sum(money) / len(money)
    count = 0
    for i in money:
        if i <= avg:
            count += 1

    print("#{} {}".format(tc, count))