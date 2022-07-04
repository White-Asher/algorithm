arr = [False for i in range(0,10001)]

for i in range(1, 10001):
    sum = 0
    n = i
    while (1):
        if n == 0:
            break;
        a = n % 10
        sum = sum + a
        n = int(n/10)
    result = sum + i
    if(i == result):
        break
    elif(result>10000):
        continue
    arr[result] = True

for j in range(1,10001):
    if(arr[j] == False):
        print(j)