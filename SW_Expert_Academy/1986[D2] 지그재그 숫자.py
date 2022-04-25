T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    plus = 0
    minus = 0
    for i in range(1, n+1):
        if i % 2 != 0:
            plus += i
        else:
            minus += i
    print("#{} {}".format(test_case,plus - minus))