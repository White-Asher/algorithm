n = int(input())
num_list = list(map(int,input().split()))

result = 1
increase_temp = 1
decrease_temp = 1

for i in range(0, n-1):
    if num_list[i] <= num_list[i+1]:
        increase_temp += 1
        if increase_temp > result:
            result = increase_temp
        else:
            result
    else:
        increase_temp = 1
        
for j in range(0, n-1):
    if num_list[j] >= num_list[j+1]:
        decrease_temp += 1
        if decrease_temp > result:
            result = decrease_temp
        else:
            result
    else:
        decrease_temp = 1
        
print(result)

# 더 짧은 풀이
n=int(input())
arr=list(map(int, input().split()))
dp=[[1]*n for _ in range(2)]
for i in range(1,n):
    if arr[i]>=arr[i-1]:
        dp[0][i]=max(dp[0][i], dp[0][i-1]+1)
    if arr[i]<=arr[i-1]:
        dp[1][i]=max(dp[1][i], dp[1][i-1]+1)
print(max(max(dp[0]), max(dp[1])))