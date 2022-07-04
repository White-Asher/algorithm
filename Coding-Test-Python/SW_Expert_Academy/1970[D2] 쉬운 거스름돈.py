T = int(input())
money = [50000,10000,5000,1000,500,100,50,10]
for test_case in range(1, T + 1):
    n = int(input())
    n_mon = []
    for i in money:
        if n >= i :
            n_mon.append(int(n/i))
        else:
            n_mon.append(0)
        n = n - int((n/i))*i
    print("#{}".format(test_case))
    print(*n_mon)

# 다른 답안
T = int(input())
for tc in range(1,T+1):
    N = int(input())
    money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    print("#{} ".format(tc))
    for i in money: 
        print(N // i,end=' ')
        N %= i
    print()