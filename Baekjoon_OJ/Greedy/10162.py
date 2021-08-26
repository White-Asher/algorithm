inputTime = int(input())

timeSet = [300, 60, 10]
timeCount = [0,0,0]

if((inputTime % timeSet[2]) == 0):
    for a in range(0, len(timeSet)):
        timeCount[a] += inputTime // timeSet[a]
        inputTime %= timeSet[a]
        print(timeCount[a], end=' ')
    
else:
    timeCount = - 1
    print(timeCount)