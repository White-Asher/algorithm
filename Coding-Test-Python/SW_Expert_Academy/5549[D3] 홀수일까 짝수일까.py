t = int(input())
for tc in range(1,t+1):
    n = list(input())
    if int(n[-1]) % 2 == 0:
        result = 'Even'
    else:
        result = 'Odd'
    print("#{} {}".format(tc, result))