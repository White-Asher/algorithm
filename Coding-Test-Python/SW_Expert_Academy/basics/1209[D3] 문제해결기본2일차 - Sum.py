for tc in range(1, 11):
    t = int(input())
    numList = [list(map(int, input().split())) for _ in range(100)]
    sumList = []
    for i in range(100):
        cSum = 0
        lSum = 0

        for j in range(100):
            cSum += numList[i][j]
            lSum += numList[j][i]
        sumList.append(cSum)
        sumList.append(lSum)

    diaSum = 0
    for i in range(100):
        j = 0
        diaSum += numList[i][j]
    sumList.append(diaSum)

    diaSum = 0
    for i in range(0,100,-1):
        j = 0
        diaSum += numList[i][j]
    sumList.append(diaSum)

    print("#{} {}".format(tc, max(sumList)))