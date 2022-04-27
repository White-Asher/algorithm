def col_check(k):
    result = 0
    
    for i in range(n):
        count = 0
        for j in range(n):
            if arr[i][j] == 1:
                count += 1
            if arr[i][j] == 0 or j == n-1: 
                if count == k:
                    result += 1
                count = 0
    return result

def row_check(k):
    result = 0
    for i in range(n):
        count = 0
        for j in range(n):
            if arr[j][i] == 1:
                count += 1
            if arr[j][i] == 0 or j == n-1: 
                if count == k:
                    result += 1
                count = 0
        
    return result

T = int(input())
for test_case in range(1, T + 1):
    n, k = map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(n)]
    result_num = col_check(k) + row_check(k)
    print("#{} {}".format(test_case,result_num))
    
# 다른 답안
for tc in range(1, int(input())+1):
    N, K = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    result = 0
 
    for i in range(N):
        cnt = 0
        for j in range(N):
            if arr[i][j] == 1:
                cnt += 1
            if arr[i][j] == 0 or j == N-1:
                if cnt == K:
                    result += 1
                cnt = 0
        for j in range(N):
            if arr[j][i] == 1:
                cnt += 1
            if arr[j][i] == 0 or j == N-1:
                if cnt == K:
                    result += 1
                cnt = 0
 
 
    print('#{} {}'.format(tc, result))