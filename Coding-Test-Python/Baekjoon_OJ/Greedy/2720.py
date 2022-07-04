testCase = int(input())
inputMoney = []
changeMoney = [25,10,5,1]
count = [0,0,0,0]

for a in range(testCase):
    i = int(input())
    inputMoney.append(i)

for a in range(testCase):
    count = [0,0,0,0]
    for b in range(4):
        count[b] = inputMoney[a] // changeMoney[b]
        inputMoney[a] %= changeMoney[b]
        print(count[b], end=' ')
    print("")