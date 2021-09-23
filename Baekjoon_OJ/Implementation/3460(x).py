n = int(input())

for _ in range(n):
    a = bin(int(input()))[2:]
    for i in range(len(a)):
        if a[-i-1] == '1':
            print(i, end = " ")