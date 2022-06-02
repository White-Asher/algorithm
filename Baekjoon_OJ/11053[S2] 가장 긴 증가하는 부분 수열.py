n = int(input())
numList = list(map(int, input().split()))
lenNum = len(numList)

dp = [1] * lenNum

for i in range(lenNum):
    for j in range(i):
        if numList[j] < numList[i]:
            dp[i] = max(dp[i], dp[j]+1)
print(max(dp))