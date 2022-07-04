data = []
sum = 0
for i in range(7):
    inputNum = int(input())
    if inputNum %2 == 1:
        data.append(inputNum)
        sum += inputNum

if data:
    print(sum)
    print(min(data))

else:
    print(-1)