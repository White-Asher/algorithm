T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    num = [2,3,5,7,11]
    abcde = [0 for _ in range(5)]
    while N != 1:
        for i in range(len(num)):
            if N % num[i] == 0:
                abcde[i] += 1
                N = N // num[i]
                break
    
    print("#{}".format(test_case), end=' ')
    for a in range(len(abcde)):
        print(abcde[a], end=' ')
    print()