t = int(input())
for tc in range(1, t+1):
    s = input()
    a = b = 1
    for i in s:
        if i == 'L':
            b += a
        else:
            a += b
    print("#{} {} {}".format(tc,a,b))