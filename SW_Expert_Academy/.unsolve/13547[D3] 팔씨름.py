T = int(input())
for test_case in range(1, T + 1):
    w = input()
    value = 15 - len(w)
    if value < 0:
        value = 0

    if w.count('o') + value >= 8 :
        res = 'YES'
    else:
        res = 'NO'

    print("#{} {}".format(test_case, res))