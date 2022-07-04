# # dp로 풀었을 떄
import sys
input = sys.stdin.readline

arr = [0] * 11
arr[1] = 1
arr[2] = 2
arr[3] = 4

for _ in range(int(input())):
    n = int(input())

    for i in range(4, n + 1):
        arr[i] = arr[i-3] + arr[i-2] + arr[i-1]

    print(arr[n])


# DFS로 풀었을 때
import sys
input = sys.stdin.readline

def dp(x):
    if x == 1:
        return 1
    elif x == 2:
        return 2
    elif x == 3:
        return 4
    else:
        return dp(x-1) + dp(x-2) + dp(x-3)

for _ in range(int(input())):
    n = int(input())
    print(dp(n))

# 둘이 실행시간이 같다...
# 접근 방법 참고 https://yongku.tistory.com/1273